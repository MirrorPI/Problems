select case 
        when month(differentiation_date) >= 1 and month(differentiation_date) < 4 then '1Q'
        when month(differentiation_date) >= 4 and month(differentiation_date) < 7 then '2Q'
        when month(differentiation_date) >= 7 and month(differentiation_date) < 10 then '3Q'
        when month(differentiation_date) >= 10 and month(differentiation_date) <= 12 then '4Q'
        end as quarter,
        count(*) as ecoli_count
from ecoli_data
group by quarter 
order by quarter asc