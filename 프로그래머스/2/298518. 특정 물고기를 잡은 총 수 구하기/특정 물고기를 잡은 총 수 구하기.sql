select count(*) as FISH_COUNT
from fish_info fi
inner join fish_name_info fni
on fi.fish_type = fni.fish_type
where fish_name = 'BASS' || fish_name = "SNAPPER"