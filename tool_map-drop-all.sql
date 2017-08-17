alter table if exists link drop constraint if exists fk_link_tool_tool_name;
drop index if exists ix_link_tool_tool_name;

alter table if exists property_dimension drop constraint if exists fk_property_dimension_property;
drop index if exists ix_property_dimension_property;

alter table if exists property_dimension drop constraint if exists fk_property_dimension_dimension;
drop index if exists ix_property_dimension_dimension;

alter table if exists rating drop constraint if exists fk_rating_tool_tool_name;
drop index if exists ix_rating_tool_tool_name;

alter table if exists tool_property drop constraint if exists fk_tool_property_tool;
drop index if exists ix_tool_property_tool;

alter table if exists tool_property drop constraint if exists fk_tool_property_property;
drop index if exists ix_tool_property_property;

drop table if exists dimension cascade;

drop table if exists link cascade;

drop table if exists property cascade;

drop table if exists property_dimension cascade;

drop table if exists rating cascade;

drop table if exists tool cascade;

drop table if exists tool_property cascade;

