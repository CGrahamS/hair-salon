# _Hair Salon_

### _Epicodus: Java Week 3, Database Basics: Independent Project_

#### By _**Caleb Stevenson**_

## Description

This webpage will allow employees of a salon to add new stylists, add clients to that stylist, update information about both stylists and clients and delete both stylists and clients.

## Specs

| BEHAVIOR                                                   | INPUT                                                   | OUTPUT                                                                |
|------------------------------------------------------------|---------------------------------------------------------|-----------------------------------------------------------------------|
| Program will create new stylist entry.                     | Mike                                                    | _Mike_                                                                |
| Program will create a new client entry for a stylist entry.| Cathy                                                   | _Mike_ <ul><li>_Cathy_</li></ul>                                      |
| Program will create multiple clients for a stylist entry.  | Martha                                                  | _Mike_ <ul><li>_Cathy_</li><li>_Martha_</li></ul>                     |
| Program will create notes for a client entry.              | Cathy: "Usually gets a trim. Does not like small talk." | _Mike_ <ul><li>_Cathy_</li><ul><li>Usually gets a trim. Does not like small talk.</li></ul><li>_Martha_</li></ul> |
| Program will create an appointment for a client entry.     | Cathy: 10-3-2016                                        | _Mike_ <ul><li>_Cathy_</li><ul><li>Usually gets a trim. Does not like small talk.</li><li>Appointment: 10-3-2016</li></ul><li>_Martha_</li></ul> |
| Program will update entries.                               | Update: Mike <br> "Michael"                             | _Michael_ <ul><li>_Cathy_</li><ul><li>Usually gets a trim. Does not like small talk.</li><li>Appointment: 10-3-2016</li></ul><li>_Martha_</li></ul> |
| Program will delete entries.                               | Delete: Cathy                                           | _Michael_ <ul><li>_Martha_</li></ul>                                  |

## Setup/Installation Requirements

* In your first terminal window:
  * Start postgres: `$ postgres`
* In your second terminal window:
  * Start psql: `$ psql`
  * Create database: `# CREATE DATABASE hair_salon;`
* In your third terminal window:
  * Clone this repository to your desktop: `$ cd Desktop; git clone https://github.com/CGrahamS/hair-salon`
  * Navigate to the hair-salon directory: `$ cd hair-salon`
  * Create database schema from hair_salon.sql: `$ psql hair_salon < hair_salon.sql`
* Back in your second terminal window:
  * Confirm the database has been restored correctly:
    * Connect to hair_salon database: `# \c hair_salon;`
    * Print out database tables: `# \dt;`
    <br>
    NOTE: You should see "stylists" and "clients" tables in the "hair_salon" database.
* Back in your third terminal window:
  * Run the server: `$ gradle run`
* In the browser of your choosing, navigate to "localhost:4567" (tested in Chrome).

## Known Bugs

_None_

## Support and contact details

Caleb Stevenson: _cgrahamstevenson@gmail.com_

## Technologies Used

_Java,
Spark,
Velocity,
Sql_

### License

This webpage is licensed under the GPL license.

Copyright &copy; 2016 **_Caleb Stevenson_**
