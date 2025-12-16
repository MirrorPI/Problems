select count(*) as FISH_COUNT, month(TIME) as MONTH
from fish_info
group by month(time)
order by MONTH ASC