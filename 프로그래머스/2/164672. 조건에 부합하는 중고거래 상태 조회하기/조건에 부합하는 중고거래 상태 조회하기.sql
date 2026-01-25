select board_id, 
        writer_id, 
        title, price, 
        case 
            when b.status = 'sale' then '판매중'
            when b.status = 'reserved' then '예약중'
            when b.status = 'done' then '거래완료'
            END AS 'STATUS'
from used_goods_board b
where created_date = '2022-10-05'
order by board_id desc