select left(product_code, 2) as CATEGORY, count(*) PRODUCTS
from product
group by CATEGORY
order by CATEGORY asc