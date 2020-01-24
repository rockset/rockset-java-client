# Rockset Java Client Changelog

## v0.7.0 2020-01-21
- introduce saved queries
- add document patch ability
- bug fix for Tableau where timestamp fields could appear as strings or nulls
- only describe top-level fields for collections to speed up clients
- misc fixes and improvements

## v0.6.3 2019-11-20
- Don't write any logs to stdout (fixes Tableau 2019.3+ compatibility issue)

## v0.6.2 2019-11-07
- Undo mapping from Rockset timestamp to SQL timestamp with timezone type (Tableau compatibility issue)

## v0.6.1 2019-09-06
- Properly set ResultSet.wasNull for cleaner null handling in higher level applications
- Fix bug where floats were truncated to ints
- Map Rockset datetime to SQL timestamp type and Rockset timestamp to SQL timestamp with timezone type
- Ignore nulls when determining column type for result set
- Display all Rockset workspaces in the schema list

## v0.6.0 2019-06-17
- move from cloud-level integrations to service-level integrations: DynamoDB, GCS, Kinesis, Redshift, S3

## v0.5.13 2019-04-02
- Fixed issue where Tableau complains if query returns zero results using JDBC
- More logging and unit tests

## v0.5.12 2019-03-11
- JDBC driver throws connect exception if unable to connect to rockset service
- Workspace unit tests

## v0.5.11 2019-03-07
- JDBC driver now supports Tableau
- Workspace support added in client

## v0.5.10 2019-01-23
- Added support for Google Cloud Storage

## v0.5.9 2019-01-14
- Added support for AWS External ID as a new type of integration
- rockset-jdbc driver is now part of rockset-java-client

## v0.5.8 2018-12-28
- Support for creating collections from XML data files
- Support for prefix patterns in S3 sources

## v0.4.8 2018-11-14
- handle error with client creation
- update examples and javadocs

## v0.4.7 2018-10-28
- Initial client release
