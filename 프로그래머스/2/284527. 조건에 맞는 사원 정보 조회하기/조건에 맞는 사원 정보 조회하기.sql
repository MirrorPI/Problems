SELECT sum(g.score) as SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
FROM HR_EMPLOYEES e
INNER JOIN HR_GRADE g
ON e.emp_no = g.emp_no
group by emp_no
order by SCORE desc
limit 1