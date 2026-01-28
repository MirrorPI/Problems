select distinct c.car_id
from car_rental_company_car c
inner join car_rental_company_rental_history h
on c.car_id = h.car_id
where month(h.start_date) = '10' and c.car_type = '세단'
order by c.car_id desc
