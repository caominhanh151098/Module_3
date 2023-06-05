select o_id, o_date, o_total_price
from quan_ly_ban_hang.order;

select c.c_name, p.p_name
from customer c join quan_ly_ban_hang.order o on c.c_id = o.c_id
				join order_detail od on o.o_id = od.o_id
                join product p on od.p_id = p.p_id;
                
                
select c.c_name
from customer c
where c.c_name not in (select distinct c.c_name
						from customer c join quan_ly_ban_hang.order o on c.c_id = o.c_id);
                        

select o.o_id, o.o_date, SUM(od.od_qty * p.p_price)
from quan_ly_ban_hang.order o join order_detail od on od.o_id = o.o_id
							join product p on od.p_id = p.p_id
GROUP BY o.o_id;