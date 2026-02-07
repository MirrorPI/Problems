select h.dept_id, dept_name_en, round(avg(e.sal), 0) as avg_sal
from hr_department h
inner join hr_employees e
on h.dept_id = e.dept_id
group by dept_id
order by avg_sal desc
