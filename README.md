# Car Booking Portal
![image](https://github.com/dpk915/filthy-receipt-7691/assets/54777923/864c4a05-ed00-4fa8-a25a-7e902afed916)


The Car Booking Portal is an online platform designed to facilitate the process of booking cars for users. This repository contains the code and resources required to run the car booking portal application. It provides users with the ability to register, log in, browse available cars, and book them. Admin users have additional functionalities to manage car details, confirm or reject car bookings, and generate reports on bookings.

## Table of Contents
- Installation
- Usage
- Database Schema
- Contributing
-License

## Installation
To install and run the car booking portal application, follow these steps:

1. Clone this repository to your local machine or server.
2. Install the required dependencies by running npm install or yarn install.
3. Set up the MySQL database by importing the database schema file (database.sql) included in the repository.
4. Configure the database connection settings in the config.js file.
5. Start the application by running npm start or yarn start.
Usage
Once the car booking portal application is up and running, users can access it through a web browser by entering the URL of the application. The homepage will provide options to register as a user or log in.

## User Functions
- Register: Users can create a new account by providing the necessary information.
- Log in: Registered users can log in using their credentials.
- Browse Cars: Users can view available cars with details such as car model, brand, price, and availability.
- Apply Filters and Sorting: Users can apply filters and sorting options to refine their search for car details.
- Book a Car: Users can select a desired car and provide booking details to book it.
- View Booking Status: Users can view the status of their car bookings, including confirmation or rejection status.
- Log out: Users can log out from the car booking portal.
## Admin Functions
- Register: Admin users can create a new admin account by providing the necessary information.
- Log in: Admin users can log in using their credentials.
- Add Car Details: Admin users can add new car details to the portal, including car model, brand, price, and availability.
- Update Car Details: Admin users can update existing car details, such as availability and price.
- Delete Car Details: Admin users can delete car details from the portal.
- Confirm or Reject Bookings: Admin users can confirm or reject car bookings made by users.
- Generate Reports: Admin users can generate reports on car bookings, including the number of bookings and revenue generated.
- Log out: Admin users can log out from the admin account.
## Database Schema
The car booking portal uses a MySQL database to store information related to users, cars, bookings, and reports. The database schema is designed to maintain appropriate relationships and constraints between tables, such as foreign keys and unique constraints. Refer to the ER-Diagram in the repository to visualize the database structure and relationships.

## Contributing
Contributions to the Car Booking Portal are welcome! If you have any ideas, suggestions, or bug reports, please open an issue on the GitHub repository.

To contribute code, follow these
