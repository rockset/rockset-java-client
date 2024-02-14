# Rockset Java Client Changelog

## v0.13.0 2024-02-14
- TODO

## v0.12.0 2024-01-15
- Add ScheduledQueryLambda support

## v0.11.4 2023-12-14
- Added "XSMALL" VI size
- Introduced `expiry_time` for API key
- Deprecated `mount_refresh_interval_seconds`, replacing it with `mount_type` for handling data refreshes on Virtual Instances
- Added `bson` data type support
- Added DynamoDB source configuration

## v0.10.3 2023-09-19
- Fix async calls with okhttp3
- Support the latest Rockset API endpoints and improvements

## v0.10.2 2023-09-08
- Support the latest Rockset API endpoints and improvements
- upgrade okhttp to okhttp3

## v0.10.1 2022-08-09
- Support the latest Rockset API endpoints and improvements

## v0.10.0 2022-01-12
- Added api changes for new MSK integration
- Improved JDBC API conformance by ignoring non-Rockset urls

## v0.9.5 2022-10-17
- Support u256 SQL data type
- Improved error messages
- Fix query error deserialization

## v0.9.4 2022-10-12
- Backward compatibility fixes for response error handling
- Handle wide row result sets in JDBC efficiently

## v0.9.3 2022-09-21
- Packaging: Update default jar to avoid bundling shaded dependencies to better integrate with build tools.
- Packaging: Release a separate uberjar for use with business intelligence tools.
- Support Rockset json models for timestamp, datetime, date, and time types

## v0.9.2 2022-04-18
- Resolve certain package dependency conflicts while using rockset java client
- Backward compatibility fixes for query API
- Support java API for query lambda pagination


## v0.9.1 2021-12-10
- Support result set pagination by leveraging the new Rockset pagination feature

## v0.9.0 2021-03-10
- Introduce Aliases, IP Allowlist and Virtual Instances
- Fix a bug to ignore unknown properties in response from server

## v0.8.1 2020-03-26
- Handle `null` case in table metadata

## v0.8.0 2020-03-03
- update models and logic for Query Lambdas

## v0.7.1 2020-01-24
- only describe top-level fields for collections to speed up clients

## v0.7.0 2020-01-21
- introduce Query Lambdas
- add document patch ability
- bug fix for Tableau where timestamp fields could appear as strings or nulls
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
