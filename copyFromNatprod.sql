show user;
select * from global_name;
set timing on;
set serveroutput on;
whenever sqlerror exit failure rollback;
whenever oserror exit failure rollback;
select 'copy from natprod start time: ' || systimestamp from dual;

prompt altitude_method
truncate table altitude_method;
insert /*+ append parallel(4) */ into altitude_method
select regexp_replace(gw_ref_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_ref_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       gw_sort_nu,
       regexp_replace(gw_ref_ds, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_valid_fg, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.gw_reflist@natdb.er.usgs.gov
 where gw_ed_tbl_nm = 'saltmt';
commit;

prompt aqfr
truncate table aqfr;
insert /*+ append parallel(4) */ into aqfr
select regexp_replace(aqfr_state.country_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(aqfr_state.state_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(aqfr.aqfr_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(aqfr.aqfr_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(aqfr.aqfr_dt, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.aqfr@natdb.er.usgs.gov
       join natdb.aqfr_state@natdb.er.usgs.gov
         on aqfr.aqfr_cd = aqfr_state.aqfr_cd;
commit;

prompt aquifer_type
truncate table aquifer_type;
insert /*+ append parallel(4) */ into aquifer_type
select regexp_replace(gw_ref_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_ref_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       gw_sort_nu,
       regexp_replace(gw_ref_ds, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_valid_fg, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.gw_reflist@natdb.er.usgs.gov
 where gw_ed_tbl_nm = 'saqtyp';
commit;

prompt body_part
truncate table body_part;
insert /*+ append parallel(4) */ into body_part
select regexp_replace(body_part_id, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(body_part_nm, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.body_part@natdb.er.usgs.gov;
commit;

prompt cit_meth
truncate table cit_meth;
insert /*+ append parallel(4) */ into cit_meth
select cit_meth_id,
       regexp_replace(meth_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(cit_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(cit_meth_no, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_src_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(cit_meth_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       cit_meth_init_dt,
       regexp_replace(cit_meth_rev_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       cit_meth_rev_dt
  from natdb.cit_meth@natdb.er.usgs.gov;
commit;

prompt country - STORET still has CN as Canada, all but a few NWIS sites have been migrated, and we never expect data for China, so do not include any CN in NWIS data
truncate table country;
insert /*+ append parallel(4) */ into country
select regexp_replace(country_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(country_nm, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.country@natdb.er.usgs.gov
 where regexp_replace(country_cd, '(^[[:space:]]*|[[:space:]]*$)') != 'CN';
commit;

prompt county
truncate table county;
insert /*+ append parallel(4) */ into county
select regexp_replace(country_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_max_lat_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_min_lat_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_max_long_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_min_long_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_max_alt_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_min_alt_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(county_md, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.county@natdb.er.usgs.gov;
commit;

prompt fxd
truncate table fxd;
insert /*+ append parallel(4) */ into fxd
select regexp_replace(parm_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       fxd_va,
       regexp_replace(fxd_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(fxd_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       fxd_init_dt,
       regexp_replace(fxd_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       fxd_rev_dt,
       regexp_replace(fxd_rev_nm, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.fxd@natdb.er.usgs.gov;
commit;

prompt hyd_cond_cd
truncate table hyd_cond_cd;
insert /*+ append parallel(4) */ into hyd_cond_cd
select regexp_replace(hyd_cond_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       hyd_cond_srt_nu,
       regexp_replace(hyd_cond_vld_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(hyd_cond_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(hyd_cond_ds, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.hyd_cond_cd@natdb.er.usgs.gov;
commit;

prompt hyd_event_cd
truncate table hyd_event_cd;
insert /*+ append parallel(4) */ into hyd_event_cd
select regexp_replace(hyd_event_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       hyd_event_srt_nu,
       regexp_replace(hyd_event_vld_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(hyd_event_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(hyd_event_ds, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.hyd_event_cd@natdb.er.usgs.gov;
commit;

prompt lat_long_datum
truncate table lat_long_datum;
insert /*+ append parallel(4) */ into lat_long_datum
select regexp_replace(gw_ref_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_ref_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       gw_sort_nu,
       regexp_replace(gw_ref_ds, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_valid_fg, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.gw_reflist@natdb.er.usgs.gov
 where gw_ed_tbl_nm = 'scordm';
commit;

prompt lat_long_method
truncate table lat_long_method;
insert /*+ append parallel(4) */ into lat_long_method
select regexp_replace(gw_ref_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_ref_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       gw_sort_nu,
       regexp_replace(gw_ref_ds, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(gw_valid_fg, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.gw_reflist@natdb.er.usgs.gov
 where gw_ed_tbl_nm = 'scormt';
commit;

prompt meth
truncate table meth;
insert /*+ append parallel(4) */ into meth
select regexp_replace(meth_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_tp, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_ds, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_rnd_owner_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(discipline_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       meth_init_dt,
       regexp_replace(meth_rev_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       meth_rev_dt
  from natdb.meth@natdb.er.usgs.gov;
commit;

prompt meth_with_cit
truncate table meth_with_cit;
insert /*+ append parallel(4) */ into meth_with_cit
select meth.meth_cd,
       meth.meth_nm,
       min(cit_meth.cit_nm)
  from meth
       left join cit_meth
         on meth.meth_cd = cit_meth.meth_cd
    group by meth.meth_cd, meth.meth_nm;
commit;

prompt nat_aqfr
truncate table nat_aqfr;
insert /*+ append parallel(4) */ into nat_aqfr
select regexp_replace(nat_aqfr_state.country_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(nat_aqfr_state.state_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(nat_aqfr.nat_aqfr_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(nat_aqfr.nat_aqfr_nm, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.nat_aqfr@natdb.er.usgs.gov
       join natdb.nat_aqfr_state@natdb.er.usgs.gov
         on nat_aqfr.nat_aqfr_cd = nat_aqfr_state.nat_aqfr_cd;
commit;

prompt parm_meth
truncate table parm_meth;
insert /*+ append parallel(4) */ into parm_meth
select regexp_replace(parm_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(meth_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm_meth_lgcy_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm_meth_rnd_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm_meth_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       parm_meth_init_dt,
       regexp_replace(parm_meth_rev_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       parm_meth_rev_dt,
       regexp_replace(parm_meth_vld_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       decode(regexp_instr(parm_meth_rnd_tx, '[1-9]', 1, 1),
              1, '0.001',
              2, '0.01',
              3, '0.1',
              4, '1.',
              5, '10',
              6, '100',
              7, '1000',
              8, '10000',
              9, '100000') multiplier
  from natdb.parm_meth@natdb.er.usgs.gov;
commit;

prompt parm
truncate table parm;
insert /*+ append parallel(4) */ into parm
select regexp_replace(parm.parm_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_rmk_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_unt_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_seq_nu, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_seq_grp_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_ds, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_medium_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_frac_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_temp_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_stat_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_tm_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_wt_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_size_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_entry_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_public_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_neg_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_zero_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_null_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_ts_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_init_dt, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_rev_dt, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm.parm_rev_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       parm_seq_grp_cd.parm_seq_grp_nm,
       parm_alias.wqpcrosswalk,
       parm_alias.srsname,
       parm_meth.multiplier
  from natdb.parm@natdb.er.usgs.gov
       left join natdb.parm_seq_grp_cd@natdb.er.usgs.gov
         on regexp_replace(parm.parm_seq_grp_cd, '(^[[:space:]]*|[[:space:]]*$)') = regexp_replace(parm_seq_grp_cd.parm_seq_grp_cd, '(^[[:space:]]*|[[:space:]]*$)')
       join (select *
               from (select parm_cd, parm_alias_cd, parm_alias_nm
                       from natdb.parm_alias@natdb.er.usgs.gov
                      where parm_alias_cd in ('WQPCROSSWALK', 'SRSNAME'))
                     pivot (max(parm_alias_nm)
                            for parm_alias_cd in ('WQPCROSSWALK' wqpcrosswalk, 'SRSNAME' srsname))
               where nvl(wqpcrosswalk, srsname) is not null) parm_alias
         on regexp_replace(parm.parm_cd, '(^[[:space:]]*|[[:space:]]*$)') = regexp_replace(parm_alias.parm_cd, '(^[[:space:]]*|[[:space:]]*$)')
       left join parm_meth
         on regexp_replace(parm.parm_cd, '(^[[:space:]]*|[[:space:]]*$)') = parm_meth.parm_cd and
            parm_meth.meth_cd is null
 where parm.parm_public_fg = 'Y';
commit;

prompt parm_alias
truncate table parm_alias;
insert /*+ append parallel(4) */ into parm_alias
select regexp_replace(parm_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm_alias_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(parm_alias_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       parm_alias_init_dt,
       regexp_replace(parm_alias_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       parm_alias_rev_dt,
       regexp_replace(parm_alias_rev_nm, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.parm_alias@natdb.er.usgs.gov;
commit;

prompt proto_org
truncate table proto_org;
insert /*+ append parallel(4) */ into proto_org
select regexp_replace(proto_org_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(proto_org_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(proto_org_fv_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(proto_org_vld_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(proto_org_init_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       proto_org_init_dt,
       regexp_replace(proto_org_rev_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       proto_org_rev_dt
  from natdb.proto_org@natdb.er.usgs.gov;
commit;

prompt site_tp
truncate table site_tp;
insert /*+ append parallel(4) */ into site_tp
select regexp_replace(site_tp_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       site_tp_srt_nu,
       regexp_replace(site_tp_vld_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(site_tp_prim_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(site_tp_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(site_tp_ln, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(site_tp_ds, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.site_tp@natdb.er.usgs.gov;
commit;

prompt state
truncate table state;
insert /*+ append parallel(4) */ into state
select regexp_replace(country_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_post_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_max_lat_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_min_lat_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_max_long_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_min_long_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_max_alt_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_min_alt_va, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(state_md, '(^[[:space:]]*|[[:space:]]*$)')
 from natdb.state@natdb.er.usgs.gov;
commit;

prompt tu
truncate table tu;
insert /*+ append parallel(4) */ into tu
select tu_id,
       regexp_replace(tu_1_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_1_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_2_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_2_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_3_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_3_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_4_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_4_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_unnm_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_use_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_unaccp_rsn_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_cred_rat_tx, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_cmplt_rat_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(tu_curr_rat_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       tu_phyl_srt_nu,
       tu_cr,
       tu_par_id,
       tu_tax_auth_id,
       tu_hybr_auth_id,
       tu_king_id,
       tu_rnk_id,
       tu_md
  from natdb.tu@natdb.er.usgs.gov;
commit;

prompt val_qual_cd
truncate table val_qual_cd;
insert /*+ append parallel(4) */ into val_qual_cd
select regexp_replace(val_qual_cd, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(val_qual_tp, '(^[[:space:]]*|[[:space:]]*$)'),
       val_qual_srt_nu,
       regexp_replace(val_qual_vld_fg, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(val_qual_nm, '(^[[:space:]]*|[[:space:]]*$)'),
       regexp_replace(val_qual_ds, '(^[[:space:]]*|[[:space:]]*$)')
  from natdb.val_qual_cd@natdb.er.usgs.gov;
commit;

select 'copy from natprod end time: ' || systimestamp from dual;
