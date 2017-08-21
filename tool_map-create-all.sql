create table dimension (
  name                          varchar(255) not null,
  index                         integer not null,
  description                   varchar(255) not null,
  constraint uq_dimension_index unique (index),
  constraint pk_dimension primary key (name)
);

create table link (
  link_text                     varchar(255) not null,
  tool_tool_name                varchar(255) not null,
  name                          varchar(255) not null,
  constraint pk_link primary key (link_text)
);

create table property (
  name                          varchar(255) not null,
  constraint pk_property primary key (name)
);

create table property_dimension (
  property_name                 varchar(255) not null,
  dimension_name                varchar(255) not null,
  constraint pk_property_dimension primary key (property_name,dimension_name)
);

create table rating (
  uuid                          uuid not null,
  tool_tool_name                varchar(255) not null,
  text                          varchar(255) not null,
  context                       varchar(255) not null,
  author                        varchar(255) not null,
  stars                         integer not null,
  date                          date not null,
  constraint pk_rating primary key (uuid)
);

create table tool (
  tool_name                     varchar(255) not null,
  description                   varchar(255) not null,
  rating                        integer not null,
  constraint pk_tool primary key (tool_name)
);

create table tool_property (
  tool_tool_name                varchar(255) not null,
  property_name                 varchar(255) not null,
  constraint pk_tool_property primary key (tool_tool_name,property_name)
);

alter table link add constraint fk_link_tool_tool_name foreign key (tool_tool_name) references tool (tool_name) on delete restrict on update restrict;
create index ix_link_tool_tool_name on link (tool_tool_name);

alter table property_dimension add constraint fk_property_dimension_property foreign key (property_name) references property (name) on delete restrict on update restrict;
create index ix_property_dimension_property on property_dimension (property_name);

alter table property_dimension add constraint fk_property_dimension_dimension foreign key (dimension_name) references dimension (name) on delete restrict on update restrict;
create index ix_property_dimension_dimension on property_dimension (dimension_name);

alter table rating add constraint fk_rating_tool_tool_name foreign key (tool_tool_name) references tool (tool_name) on delete restrict on update restrict;
create index ix_rating_tool_tool_name on rating (tool_tool_name);

alter table tool_property add constraint fk_tool_property_tool foreign key (tool_tool_name) references tool (tool_name) on delete restrict on update restrict;
create index ix_tool_property_tool on tool_property (tool_tool_name);

alter table tool_property add constraint fk_tool_property_property foreign key (property_name) references property (name) on delete restrict on update restrict;
create index ix_tool_property_property on tool_property (property_name);

