------------------------------------------------
-- Export file for user BAOKANG               --
-- Created by kedacom on 2017/10/20, 11:51:19 --
------------------------------------------------

spool wfcl.log

prompt
prompt Creating table V_WFCL
prompt =====================
prompt
create table V_WFCL
(
  TOLLNO     VARCHAR2(32),
  LANENO     NUMBER(6),
  DIRECTION  VARCHAR2(8),
  PLATENO    VARCHAR2(16),
  PLATECOLOR VARCHAR2(2),
  WFLX       VARCHAR2(32),
  VEHCSPEED  NUMBER(4),
  PASSTIME   DATE,
  VEHCCOLOR  VARCHAR2(2),
  VEHCLENGTH NUMBER(5,2),
  WFTP       BLOB,
  RKSJ       DATE
)
tablespace EZVIEW
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

	
//    
//    "_source": {
//    	"F_CDFX": "SN",
//    	"F_SUNVISOR_CONF": "0",
//    	"F_TEMP_PLATE_NUM": "-1",
//    	"F_DAY": "0",
//    	"F_START_TIME_H": "17092018",
//    	"F_PLATE_COLOR": "2",
//    	"F_PLATE_CHARACTOR_CONF_LAST_MIN": "64",
//    	"F_OBJ_ID": "0",
//    	"F_SUNROOF_NUM": "1",
//    	"F_VEH_SIZE": "0",
//    	"F_VEH_COLOR_DEPTH": "1",
//    	"F_SUNVISOR_VICE_DRIVING_CONF": "0",
//    	"F_CDBH": "2",
//    	"F_VEH_LOGO_SUB_BRAND_YEAR": "2011款",
//    	"F_PLAY_PHONE": "0",
//    	"F_SUB_OBJ_ID": "0",
//    	"F_LABEL_SHAPE": "0,0,0",
//    	"F_TISSUEBOX_NUM": "0",
//    	"F_END_TIME": "2017-09-20 18:16:53.000",
//    	"F_VEH_SIZE_CONF": "100",
//    	"F_BRIGHTNESS": "63.03",
//    	"F_PIC_PATH1": "http://172.21.229.84:8090/jpgs/519029780602-20170501070105-1-1.jpg",
//    	"F_START_TIME": "2017-09-20 18:16:53.000",
//    	"F_SEAT_BELT_STATUS": "1",
//    	"F_START_TIME_M": "1709201816",
//    	"F_START_TIME_L": "1505902613000",
//    	"F_SMOKING": "0",
//    	"F_END_TIME_L": "1505902613000",
//    	"F_PENDANT_NUM": "0",
//    	"F_VEH_SPEED": "80",
//    	"F_END_TIME_H": "17092018",
//    	"F_XZQH": "320432",
//    	"F_TEMP_PLATE_CONF": "0",
//    	"F_VEH_MANUFACTOR": "东风标致",
//    	"F_HPHM": "苏D2U312",
//    	"F_SMOKING_CONF": "0",
//    	"F_LP_RECT1": "{"x":1789,"y":1569,"w":139,"h":40}",
//    	"F_END_TIME_M": "1709201816",
//    	"F_PLATE_NUM": "1",
//    	"F_JLBH": "620390010220170920181653258",
//    	"F_TASK_NO": "0",
//    	"F_FRONT_BACK": "0",
//    	"F_VEH_LOGO_BRAND": "标致",
//    	"F_HPYS": "2",
//    	"F_PLAY_PHONE_CONF": "0",
//    	"F_VEH_RECT1": "{"x":1608,"y":1111,"w":526,"h":536}",
//    	"F_SRC_PROP": "1",
//    	"F_HOLD_PHONE": "0",
//    	"F_VIEW_TYPE1": "1",
//    	"F_VEH_COLOR_CONF": "100",
//    	"F_PLATE_NAME": "苏D2U312",
//    	"F_BEST_PIC_INDEX": "1",
//    	"F_VEH_LOGO_BRAND_CONF": "94",
//    	"F_SNAP_NO1": "0",
//    	"F_PLATE_CHARACTOR_CONF_FIRST": "99",
//    	"F_SEATBELT_VICE_DRIVING": "-1",
//    	"F_VEH_LOGO_SUB_BRAND": "标致207",
//    	"F_PLATE_CONF": "94",
//    	"F_EXIST_SUNVISOR": "-1",
//    	"F_HOLD_PHONE_CONF": "0",
//    	"F_SUNVISOR_VICE_DRIVING": "-1",
//    	"F_TASK_ID": "620390010220170920181653258",
//    	"F_VEH_COLOR": "4",
//    	"F_PLATE_CHARACTOR_CONF": "100.00,99.99,99.99,99.98,64.49,100.00,100.00",
//    	"F_SNAP_TIME1": "2017-09-20 18:16:53.000",
//    	"F_PLATE_TYPE": "1",
//    	"F_PLATE_CHARACTOR_NUM": "7",
//    	"F_LABEL_COLOR": "0,0,0",
//    	"F_VEH_TYPE": "2",
//    	"F_PLATE_STRUCTURE": "0",
//    	"F_PERSON_NUM": "1",
//    	"F_SEAT_BELT_CONF": "0",
//    	"F_SEATBELT_VICE_DRIVING_CONF": "0",
//    	"F_SBBH": "62039001",
//    	"F_SUNVISOR_COUNT": "-1",
//    	"F_BEST_PIC_ID": "620390010220170920181653258",
//    	"F_LABEL_NUM": "3"
//    	}
