


select b.title,
        b.board_id,
        r.reply_id,
        r.writer_id,
        r.contents,
        substr(r.created_date, 1, 10) as created_date
from used_goods_board as b
inner join used_goods_reply as r 
on b.board_id = r.board_id
where substr(b.created_date, 1, 7) = "2022-10"
order by r.created_date asc, b.title asc