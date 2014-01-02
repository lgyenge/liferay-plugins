create table orgsetup_Ceg (
	cegId LONG not null primary key,
	azon_r LONG,
	subAzon_r LONG,
	category_r VARCHAR(75) null,
	orgname_r VARCHAR(75) null,
	azon_u LONG,
	subAzon_u LONG,
	liferayOrgId LONG,
	orgname VARCHAR(75) null,
	logo VARCHAR(256) null,
	categoryId LONG,
	category VARCHAR(256) null,
	postalcode VARCHAR(75) null,
	city VARCHAR(75) null,
	street VARCHAR(75) null,
	contact VARCHAR(75) null,
	web VARCHAR(75) null,
	description STRING null,
	htmldescription TEXT null,
	keywords VARCHAR(2000) null,
	pageURL VARCHAR(256) null,
	pagename VARCHAR(75) null,
	date_ DATE null,
	pageURLAzon VARCHAR(256) null
);

create table orgsetup_Foo (
	fooId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table orgsetup_Org (
	orgID LONG not null primary key,
	origAzon LONG,
	azon_r LONG,
	subAzon_r LONG,
	category_r VARCHAR(75) null,
	orgname_r VARCHAR(75) null,
	city VARCHAR(75) null,
	address1 VARCHAR(75) null,
	postalCode VARCHAR(75) null,
	webURL VARCHAR(75) null,
	contact VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	description STRING null,
	keywords VARCHAR(2000) null,
	imageURL VARCHAR(512) null
);

create table orgsetup_Product (
	azon LONG not null primary key,
	name VARCHAR(75) null,
	description STRING null,
	services VARCHAR(256) null,
	image VARCHAR(256) null,
	datasheet VARCHAR(75) null,
	distributor VARCHAR(75) null,
	category VARCHAR(256) null,
	subcategory VARCHAR(256) null,
	pageURL VARCHAR(256) null,
	pagetitle VARCHAR(256) null,
	startingpage VARCHAR(256) null,
	date_ DATE null,
	liferayOrgId LONG,
	pageURLAzon VARCHAR(256) null
);