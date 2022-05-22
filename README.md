# Hotel Management System [![CircleCI](https://circleci.com/gh/rahulraogrr/hms/tree/main.svg?style=svg)](https://circleci.com/gh/rahulraogrr/hms/tree/main) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/2b5cbf01886a4cbab07cdb9620ff31af)](https://www.codacy.com/gh/rahulraogrr/hms/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=rahulraogrr/hms&amp;utm_campaign=Badge_Grade) ![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/rahulraogrr/hms) 

Follow me on Twitter ![Twitter Follow](https://img.shields.io/twitter/follow/rahulrao20?style=social)

About application: https://rahulraogrr.github.io/hms/

## Description

Hotel Management System API is built for groups who have chain of hotels. This has two modules as mentioned below
1. Admin Module
2. HMS Portal

<u>Admin Module</u>: In this module hotels can define a group under which hotels can created. Admin users can do the following activites mentioned below
1. Group Master : Admin will create group under which hotels can be listed/added. Ex: Taj Group of hotels
2. Hotel Master : Hotels will be added under group. Users can add n number of hotels under a group including the location.
3. Floor Master : Floors must be added for a hotel.
4. Room Master : Rooms must be added for a created floor
5. Department Master : Departments must be created for a specific hotel
6. Employee Master : Employees will be working in various departments in a hotel.

<u>HMS Portal</u>: In this module hotel employees can maintain the incoming customer flow.

## Technology Stack

| Sr No | Type                 | Technology | Version |
|-------|----------------------|------------|---------|
| 1     | Programming Language | Java       | 11      |
| 2     | Framework            | SpringBoot | 2.6.7   |
| 3     | Database             | Postgres   | 14.2    |

## ER Diagram
![image description](src/main/resources/static/images/er_diagram.png)
