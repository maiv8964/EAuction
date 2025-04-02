# EECS 4413 E Auction Project

- This project is designed to replicate an online auction site, where users can place bids on listed items.
- This application is completely dockerized so there is no need to set up Apache Tomcat or SQLite just need to setup docker

# Setup docker
- If Docker Desktop is yet to be installed on your local machine please visit https://www.docker.com/products/docker-desktop/


- Once installed, in the project directory run
```
docker-compose up --build
```
- This should be ran in the same directory that `eAuctiondb.db` and `pom.xml` exist in

# Accessing localhost
- To access the localhost, visit `http://localhost:8080/EAuction/login` and login with the credential
```
username: vincent
password: mai
```
- You should be taken to a login page such as the image below:
- ![image](https://github.com/user-attachments/assets/b97db110-bdc4-4eaf-9efa-45177dd4e5a7)


# To view the database
Alternatively you can still view the database using SQLite's GUI to do this you must:
- Ensure you have sqlite installed

- View https://www.sqlite.org/download.html if not

- Double click on `eAuctiondb.db` to open it with SQLite
- See image below:
![image](https://github.com/user-attachments/assets/25f8e706-0b15-41ee-aa2b-969e137d185a)

- And this should take you to SQLite's GUI where you can check out the database tables and values
