/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */ 
package com.datamelt.db;

/**
 * Contains the sql code to create the database tables and fields required
 * by this web application.
 * 
 * When the web application is started the first time or when the database configuration
 * was changed, this class is used.
 * 
 * @author uwe geercken
 *
 */
public class CreateDatabase
{
	public static final String TABLE_ACTION = "`action`";
	public static final String TABLE_ACTION_METHOD = "`action_method`";
	public static final String TABLE_CHECK = "`check`";
	public static final String TABLE_CHECK_METHOD = "`check_method`";
	public static final String TABLE_REFERENCE_FIELDS = "`reference_fields`";
	public static final String TABLE_ACTIVITY_LOG = "`activity_log`";
	public static final String TABLE_GROUPS = "`groups`";
	public static final String TABLE_HISTORY = "`history`";
	public static final String TABLE_PROJECT = "`project`";
	public static final String TABLE_RULE = "`rule`";
	public static final String TABLE_RULEGROUP = "`rulegroup`";
	public static final String TABLE_RULEGROUPACTION = "`rulegroupaction`";
	public static final String TABLE_RULESUBGROUP = "`rulesubgroup`";
	public static final String TABLE_TYPES = "`types`";
	public static final String TABLE_USER = "`user`";
	public static final String TABLE_GROUPUSER= "`groupuser`";
	public static final String TABLE_RULEGROUP_TESTDATA = "`rulegroup_testdata`";
	public static final String TABLE_JARE_VERSION = "`jare_version`";
	
	public static final String CREATE_TABLE_JARE_VERSION = "CREATE TABLE IF NOT EXISTS " + TABLE_JARE_VERSION + " ("
    		+ " `id` integer,"
    		+ " `version` varchar(255) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")" ;
	
	public static final String CREATE_TABLE_ACTION_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_ACTION + " ("
    		+ " `id` integer,"
    		+ " `description` varchar(255) DEFAULT NULL,"
    		+ " `classname` varchar(255) NOT NULL,"
    		+ " `methodname` varchar(255) DEFAULT NULL,"
    		+ " `methoddisplayname` varchar(255) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";
	
	public static final String CREATE_TABLE_ACTION_METHOD_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_ACTION_METHOD + " ("
    		+ " `id` integer,"
    		+ " `action_id` int(10) NOT NULL,"
    		+ " `return_type` varchar(80) DEFAULT NULL,"
    		+ " `method_types` varchar(80) DEFAULT NULL,"
    		+ " `note` varchar(255) DEFAULT NULL,"
    		+ " `optional_type1` varchar(80) DEFAULT NULL,"
    		+ " `optional_type1_explanation` varchar(255) DEFAULT NULL,"
    		+ " `optional_type2` varchar(80) DEFAULT NULL,"
    		+ " `optional_type2_explanation` varchar(255) DEFAULT NULL,"
    		+ " `optional_type3` varchar(80) DEFAULT NULL,"
    		+ " `optional_type3_explanation` varchar(255) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_ACTION_METHOD_SQL_INDEX = "create index `idx_actionid` on " + TABLE_ACTION_METHOD + "(`action_id`)";

    public static final String CREATE_TABLE_ACTIVITY_LOG_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_ACTIVITY_LOG + " ("
    		+ " `id` integer,"
    		+ " `activity_date` datetime DEFAULT NULL,"
    		+ " `user_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `message` varchar(255) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_ACTIVITY_LOG_SQL_INDEX = "create index `idx_last_update` on " + TABLE_ACTIVITY_LOG + "(`last_update`)";

    public static final String CREATE_TABLE_CHECK_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_CHECK + " ("
    		+ " `id` integer,"
    		+ " `name` varchar(80) NOT NULL,"
    		+ " `description` varchar(255) DEFAULT NULL,"
    		+ " `name_descriptive` varchar(255) DEFAULT NULL,"
    		+ " `package` varchar(80) DEFAULT NULL,"
    		+ " `class` varchar(80) DEFAULT NULL,"
    		+ " `check_single_field` tinyint(1) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_CHECK_SQL_INDEX = "create unique index `idx_class` on " + TABLE_CHECK + "(`class`)";

    public static final String CREATE_TABLE_CHECK_METHOD_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_CHECK_METHOD + " ("
    		+ " `id` integer,"
    		+ " `check_id` int(10) NOT NULL,"
    		+ " `compare` varchar(80) DEFAULT NULL,"
    		+ " `compare_to` varchar(80) DEFAULT NULL,"
    		+ " `note` varchar(255) DEFAULT NULL,"
    		+ " `parameter1` varchar(80) DEFAULT NULL,"
    		+ " `parameter1_explanation` varchar(255) DEFAULT NULL,"
    		+ " `parameter2` varchar(80) DEFAULT NULL,"
    		+ " `parameter2_explanation` varchar(255) DEFAULT NULL,"
    		+ " `parameter3` varchar(80) DEFAULT NULL,"
    		+ " `parameter3_explanation` varchar(255) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_CHECK_METHOD_SQL_INDEX = "create index `idx_checkid` on " + TABLE_CHECK_METHOD + "(`check_id`)";

    public static final String CREATE_TABLE_REFERENCE_FIELDS_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_REFERENCE_FIELDS + " ("
    		+ " `id` integer,"
    		+ " `project_id` int(11) NOT NULL,"
    		+ " `name` varchar(80) DEFAULT NULL,"
    		+ " `name_descriptive` varchar(80) NOT NULL,"
    		+ " `description` varchar(120) DEFAULT NULL,"
    		+ " `java_type_id` int(1) NOT NULL,"
    		+ " `last_update_user_id` int(10) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_REFERENCE_FIELDS_SQL_INDEX = "create index `idx_project_id` on " + TABLE_REFERENCE_FIELDS + "(`project_id`)";
	public static final String CREATE_TABLE_REFERENCE_FIELDS_SQL_INDEX2 = "create unique index `idx_name` on " + TABLE_REFERENCE_FIELDS + "(`project_id`,`name`)";

    public static final String CREATE_TABLE_GROUPS_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_GROUPS + " ("
    		+ " `id` integer,"
    		+ " `name` varchar(45) NOT NULL DEFAULT '',"
    		+ " `description` varchar(255) NOT NULL DEFAULT '',"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_GROUPS_SQL_INDEX = "create index `idx_name` on " + TABLE_GROUPS + "(`name`)";

    public static final String CREATE_TABLE_HISTORY_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_HISTORY + " ("
    		+ " `id` integer,"
    		+ " `type` varchar(20) NOT NULL,"
    		+ " `type_id` int(10) NOT NULL,"
    		+ " `user_id` int(10) DEFAULT NULL,"
    		+ " `parent_1` int(10) DEFAULT NULL,"
    		+ " `parent_2` int(10) DEFAULT NULL,"
    		+ " `parent_3` int(10) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_HISTORY_SQL_INDEX = "create index `idx_user_id` on " + TABLE_HISTORY + "(`user_id`)";
	public static final String CREATE_TABLE_HISTORY_SQL_INDEX2 = "create index `idx_type_typeid_userid` on " + TABLE_HISTORY + "(`type`,`type_id`,`user_id`)";
    
    public static final String CREATE_TABLE_PROJECT_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_PROJECT + " ("
    		+ " `id` integer,"
    		+ " `name` varchar(80) NOT NULL,"
    		+ " `description` varchar(255) DEFAULT NULL,"
    		+ " `export_filename` varchar(255) DEFAULT NULL,"
    		+ " `is_private` tinyint(1) DEFAULT '0',"
    		+ " `object_classname` varchar(80) DEFAULT NULL,"
    		+ " `object_method_getter` varchar(80) DEFAULT NULL,"
    		+ " `object_method_setter` varchar(80) DEFAULT NULL,"
    		+ " `database_hostname` varchar(80) DEFAULT NULL,"
    		+ " `database_name` varchar(80) DEFAULT NULL,"
    		+ " `database_tablename` varchar(80) DEFAULT NULL,"
    		+ " `database_userid` varchar(80) DEFAULT NULL,"
    		+ " `database_user_password` varchar(80) DEFAULT NULL,"
    		+ " `last_update_user_id` int(10) DEFAULT NULL,"
    		+ " `owner_user_id` int(10) DEFAULT NULL,"
    		+ " `group_id` int(10) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";
    
    public static final String CREATE_TABLE_RULE_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_RULE + " ("
    		+ " `id` integer,"
    		+ " `rulesubgroup_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `check_id` int(10) DEFAULT NULL,"
    		+ " `last_update_user_id` int(10) DEFAULT NULL,"
    		+ " `name` varchar(80) NOT NULL,"
    		+ " `description` varchar(255) DEFAULT NULL,"
    		+ " `object1_parametertype_id` int(10) DEFAULT NULL,"
    		+ " `object1_parameter` varchar(255) DEFAULT NULL,"
    		+ " `object1_type_id` int(10) DEFAULT NULL,"
    		+ " `object2_parametertype_id` int(10) DEFAULT NULL,"
    		+ " `object2_parameter` varchar(255) DEFAULT NULL,"
    		+ " `object2_type_id` int(10) DEFAULT NULL,"
    		+ " `expectedvalue` mediumtext DEFAULT NULL,"
    		+ " `expectedvalue_type_id` int(10) DEFAULT NULL,"
    		+ " `additional_parameter` varchar(255) DEFAULT NULL,"
    		+ " `additional_parameter_type_id` int(10) DEFAULT NULL,"
    		+ " `message_passed` varchar(255) NOT NULL,"
    		+ " `message_failed` varchar(255) NOT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_RULE_SQL_INDEX = "create index `idx_rulesubgroup_id` on " + TABLE_RULE + "(`rulesubgroup_id`)";

    public static final String CREATE_TABLE_RULEGROUP_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_RULEGROUP + " ("
    		+ " `id` integer,"
    		+ " `project_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `last_update_user_id` int(10) DEFAULT NULL,"
    		+ " `name` varchar(80) NOT NULL,"
    		+ " `description` varchar(255) NOT NULL,"
    		+ " `valid_from` date NOT NULL,"
    		+ " `valid_until` date NOT NULL,"
    		+ " `dependent_rulegroup_id` int(10) DEFAULT NULL,"
    		+ " `dependent_rulegroup_execute_if` varchar(6) DEFAULT NULL,"
    		+ " `disabled` tinyint(2) default 0," 
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_RULEGROUP_SQL_INDEX = "create index `idx_project_id` on " + TABLE_RULEGROUP + "(`project_id`)";

    public static final String CREATE_TABLE_RULEGROUPACTION_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_RULEGROUPACTION + " ("
    		+ " `id` integer,"
    		+ " `rulegroup_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `last_update_user_id` int(10) DEFAULT NULL,"
    		+ " `action_id` int(10) NOT NULL,"
    		+ " `name` varchar(80) NOT NULL,"
    		+ " `description` varchar(255) DEFAULT NULL,"
    		+ " `object1_parametertype_id` int(10) DEFAULT NULL,"
    		+ " `object1_parameter` varchar(255) DEFAULT NULL,"
    		+ " `object1_type_id` int(10) DEFAULT NULL,"
    		+ " `object2_parametertype_id` int(10) DEFAULT NULL,"
    		+ " `object2_parameter` varchar(255) DEFAULT NULL,"
    		+ " `object2_type_id` int(10) DEFAULT NULL,"
    		+ " `object3_parametertype_id` int(10) DEFAULT NULL,"
    		+ " `object3_parameter` varchar(255) DEFAULT NULL,"
    		+ " `object3_type_id` int(10) DEFAULT NULL,"
    		+ " `parameter1` varchar(255) DEFAULT NULL,"
    		+ " `parameter1_type_id` int(10) DEFAULT NULL,"
    		+ " `parameter2` varchar(255) DEFAULT NULL,"
    		+ " `parameter2_type_id` int(10) DEFAULT NULL,"
    		+ " `parameter3` varchar(255) DEFAULT NULL,"
    		+ " `parameter3_type_id` int(10) DEFAULT NULL,"
    		+ " `execute_if` varchar(20) DEFAULT NULL,"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_RULEGROUPACTION_SQL_INDEX = "create index `idx_rulegroup_id` on " + TABLE_RULEGROUPACTION + "(`rulegroup_id`)";

    public static final String CREATE_TABLE_RULESUBGROUP_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_RULESUBGROUP + " ("
    		+ " `id` integer,"
    		+ " `rulegroup_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `last_update_user_id` int(10) DEFAULT NULL,"
    		+ " `name` varchar(80) NOT NULL,"
    		+ " `description` varchar(255) DEFAULT NULL,"
    		+ " `intergroupoperator` varchar(3) CHECK( `intergroupoperator` IN ('and','or')) NOT NULL DEFAULT 'and',"
    		+ " `ruleoperator` varchar(3) CHECK( `ruleoperator` IN ('and','or')) NOT NULL DEFAULT 'and',"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_RULESUBGROUP_SQL_INDEX = "create index `idx_rulegroup_id` on " + TABLE_RULESUBGROUP + "(`rulegroup_id`)";

    public static final String CREATE_TABLE_TYPES_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_TYPES + " ("
			+ " `id` integer,"
			+ " `name` varchar(20) DEFAULT NULL,"
			+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
			+ " PRIMARY KEY (`id`)"
			+ ")";
    
    public static final String CREATE_TABLE_USER_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " ("
    		+ " `id` integer,"
    		+ " `userid` varchar(25) NOT NULL,"
    		+ " `name` varchar(80) NOT NULL DEFAULT '',"
    		+ " `password` varchar(255) DEFAULT NULL,"
    		+ " `email` varchar(80) DEFAULT NULL,"
    		+ " `generated_code` VARCHAR(40) NULL DEFAULT NULL,"
    		+ " `lastlogin` datetime DEFAULT NULL,"
    		+ " `deactivated` tinyint(1) DEFAULT '0',"
    		+ " `deactivated_date` date DEFAULT '0000-00-00',"
    		+ " `password_update_date` date DEFAULT '0000-00-00',"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_USER_SQL_INDEX = "create unique index `idx_userid` on " + TABLE_USER + "(`userid`)";
	public static final String CREATE_TABLE_USER_SQL_INDEX2 = "create index `idx_deactivated` on " + TABLE_USER + "(`deactivated`)";

    public static final String CREATE_TABLE_GROUPUSER_SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_GROUPUSER + " ("
    		+ " `id` integer,"
    		+ " `user_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `groups_id` int(10) NOT NULL DEFAULT '0',"
    		+ " `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		+ " PRIMARY KEY (`id`)"
    		+ ")";

	public static final String CREATE_TABLE_GROUPUSER_SQL_INDEX = "create unique index `idx_groupuser` on " + TABLE_GROUPUSER + "(idx_groupuser)";
	public static final String CREATE_TABLE_GROUPUSER_SQL_INDEX2 = "create index `idx_user` on " + TABLE_GROUPUSER + "(user_id)";
	public static final String CREATE_TABLE_GROUPUSER_SQL_INDEX3 = "create index `idx_group` on " + TABLE_GROUPUSER + "(groups_id)";

    public static final String CREATE_TABLE_RULEGROUP_TESTDATA = "CREATE TABLE IF NOT EXISTS " + TABLE_RULEGROUP_TESTDATA + " ("
    		  +" `id` integer,"
    		  +" `rulegroup_id` int(10) NOT NULL,"
    		  +" `user_id` int(10) NOT NULL,"
    		  +" `value` mediumtext DEFAULT NULL,"
    		  +" `last_update` DATETIME DEFAULT CURRENT_TIMESTAMP,"
    		  +" PRIMARY KEY (`id`)"
    		  +")";

	public static final String CREATE_TABLE_RULEGROUP_TESTDATA_INDEX = "create index `idx_rulegroup_user_id` on " + TABLE_RULEGROUP_TESTDATA + "(`rulegroup_id`,`user_id`)";

    public static final String CREATE_GROUPS = "INSERT INTO " + TABLE_GROUPS + " VALUES (1,'Admin','Admin Group',current_timestamp)";
    
    public static final String CREATE_USERS = "INSERT INTO " + TABLE_USER
			+ " VALUES (1,'admin','admin user','fasthans',NULL,NULL,'2000-01-01 00:00:00',0,NULL,'2000-01-01',current_timestamp)";
    
    public static final String CREATE_GROUPUSERS = "INSERT INTO " + TABLE_GROUPUSER + " VALUES (1,1,1,current_timestamp)";
    
    public static final String CREATE_TYPES =  "INSERT INTO " + TABLE_TYPES + " VALUES (1,'string',current_timestamp),"
    			+ "(2,'integer',current_timestamp),"
    			+ "(3,'float',current_timestamp),"
    			+ "(4,'double',current_timestamp),"
    			+ "(5,'boolean',current_timestamp),"
    			+ "(6,'long',current_timestamp),"
    			+ "(7,'bigdecimal',current_timestamp),"
    			+ "(8,'date',current_timestamp)";
    }
