# TickStock

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)
2. [Product Demo Video](#Product-Demo-Video)



## Overview
### Description
An app that allows the user to view details of recent stocks, see news articles about recent stock information and edit their profile.

![tickstock1](https://github.com/XChen601/TickStock/assets/72898664/556f5614-bb4e-4f09-b456-b7996c1d0c55)



### App Evaluation
- Category: Finance
- Mobile: This app would be developed for mobile but should also be available on a computer.
- Story: Pulls stock data from Polygon.io API and allows users to view them.
- Market: Anyone with an interest in stocks or crypto.
- Habit: This app would be used when the user wants to view information on stocks.
- Scope: We start with showing stocks, news related to sticj and maybe include crypto, we could, in the future, allow the user to connect their financial accounts to the app and view their information in one place.

## Product Spec

### 1. User Stories (Required and Optional)

Required Must-have Stories

* [x] Stock fragment which displays lists of stocks pulled from an API
* [x] Stocks show open and close price
* [x] Profile page
* [x] Being able to log in and log out of account.
* [x] News fragment which displays recent stock news

Optional Nice-to-have Stories
* [x] Green or red depending if the price closed higher/lower
* [x] Add colors

### 2. Screen Archetypes


* Login Screen
  * Username and password input
* Stocks screen
  * Show list of stocks from API
* Settings/Profile
  * Lets user log out
  * Shows username
  * Change password
 * Market News
   * Shows Description of article
   * Author of Article

### 3. Navigation

Tab Navigation (Tab to Screen)

* Stocks list
* Stocks news
* Profile screen

Flow Navigation (Screen to Screen)

* Log in
   * Sign up if no log in
   * Profile page
* Stock Fragment
   * Stock symbol 
   * Stock open price
   * Stock close price
* News Fragment
   * News title
   * News author
* Profile Fragment
   * Display user's username
   * Log out button

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://i.imgur.com/PRPx0s6.jpg" width=600>

## Schema
### Models
| Property      | Type        | Description  |
| ------------- |:-------------:| ------------:|
| symbol        | string | Stock symbol seperated by comm. Max 10|
| interval      | string | price interval|
| range | string |date range |
| price | number  |Current stock price |
| User |
| favorites | Arrays|Array to hold favorited stocks/crypto|
### Networking
- Base URL - https://yfapi.net/
#### List of network requests by screen
    - Home Feed
       -(Read/GET) Get the favorite stocks/crypto from the favorites array
    - Top Stocks
       -(Update/PUT) Refreshes the screen when pulling down
    - Top Crypto
       -(Update/PUT) Refreshes the screen when pulling down
    - Favorite List
       -(Read/GET) Get the favorite stocks/crypto from the favorites array
       -(Delete/DELETE) On long hold, remove specific stock/crypto from favorites list
       -(Update/PUT) Refreshes the screen when pulling down
    -News
       -(Update/PUT) Refreshes the screen when pulling down
    -Account Overview
       -(Delete/DELETE) Clear stocks -> Deletes all favorited stocks
       -(Delete/DELETE) Clear crypto -> Deletes all favorited stocks
       -(Delete/DELETE) Clear news -> Deletes all favorited news
### User Progress Report GIF
![data](https://user-images.githubusercontent.com/73362290/162507276-375e4f04-e9d9-47f0-8382-a3dea34ae242.gif)
![Login and SignUp](https://github.com/SimpleCodepathProject/CodepathProject/blob/main/codepathProject.gif)

* [x] Setting Up a Log in and Sign page user Parse
* [x] Setting up fragments for the top stocks feed, profile, and favorited.
* [x] Successfully managed to get information from api and goes on infininetly

## Product Demo Video


https://youtu.be/-ayMhmePOxQ


