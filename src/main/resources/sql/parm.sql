select parm.parm_cd, 
	parm.parm_nm, 
	parm.parm_rmk_tx,
	parm.parm_unt_tx,
	parm.parm_seq_nu,
	parm.parm_seq_grp_cd,
	parm.parm_ds,
	parm.parm_medium_tx,
	parm.parm_frac_tx,
	parm.parm_temp_tx,
	parm.parm_stat_tx,
	parm.parm_tm_tx,
	parm.parm_wt_tx,
	parm.parm_size_tx,
	parm.parm_entry_fg,
	parm.parm_public_fg,
	parm.parm_neg_fg,
	parm.parm_zero_fg,
	parm.parm_null_fg,
	parm.parm_ts_fg,
	parm.parm_init_dt,
	parm.parm_init_nm,
	parm.parm_rev_dt,
	parm.parm_rev_nm,
	parm_seq_grp_cd.parm_seq_grp_nm, 
	pa.wqpcrosswalk,
	pa.srsname
from parm
left join parm_seq_grp_cd
         on regexp_replace(parm.parm_seq_grp_cd, '(^[[:space:]]*|[[:space:]]*$)') = regexp_replace(parm_seq_grp_cd.parm_seq_grp_cd, '(^[[:space:]]*|[[:space:]]*$)')
join
	(select
	    nvl(w.parm_cd, s.parm_cd) parm_cd, wqpcrosswalk, srsname
	from (
	        select
	            parm_alias.parm_cd,
	            parm_alias.parm_alias_cd,
	            parm_alias.parm_alias_nm wqpcrosswalk
	        from
	            parm_alias
	        where
	            parm_alias_cd = 'WQPCROSSWALK'
	    ) w
	full join (
	        select
	            parm_alias.parm_cd,
	            parm_alias.parm_alias_cd,
	            parm_alias.parm_alias_nm srsname
	        from
	            parm_alias
	        where
	            parm_alias_cd = 'SRSNAME'
	    ) s
	on w.parm_cd = s.parm_cd
	) pa
on parm.parm_cd = pa.parm_cd
where parm.parm_public_fg = 'Y'