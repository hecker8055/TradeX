
# TradeX - CryptoTradingPlatform

A full-stack cryptocurrency trading platform that empowers users to buy, sell, and trade digital assets like Bitcoin and Ethereum seamlessly. The platform leverages real-time market data, integrating the CoinGecko API to provide live price updates, market trends, and actionable insights for informed trading decisions.

For secure and efficient transactions, I integrated Razorpay and Stripe payment gateways, ensuring users can deposit and withdraw funds with confidence. User security is further reinforced with JWT-based authentication, allowing safe account management and access control.

To enhance user experience, I incorporated the Gemini API to build an intelligent chatbot, offering quick responses to trading queries and assisting users in navigating the platform.

The backend is powered by Spring Boot, providing robust, scalable, and high-performance services, while the frontend is built with React.js, delivering a smooth, responsive interface for executing trades, managing portfolios, and monitoring transactions in real-time.

This platform combines cutting-edge blockchain integration, secure payment processing, and AI-driven assistance to offer a comprehensive and user-friendly cryptocurrency trading experience.


## Tech Stack

**Client:** 
- React


**Server:**  
- SpringBoot
- Java 17
- React js
- javascript
- Tailwind css


## Key-Features

- RazorPay
- Stripe
- Real time data ( Coingecko API )
- Spring security ( JWT )
- wishlist
- wallet
- portfolio
- profile
- 2 step verification
- money transfer
- transaction history
- Activity
- withdrawal
- logout
- Otp service
- real time graph
- Buy and sell
- AI chatbot
## Entities

```
+---------------------+           +-----------------+
|       Users         |<--------->|    Wallets      |
|---------------------|           +-----------------+
| id                  |               ^            
| fullName            |               |
| email               |               |         
| ...                 |               |
+---------------------+               |
                                     |
+--------------------+            +-----------------+
|      Assets        |<---------->| WalletTransactions |
|--------------------|            +-----------------+
| id                 |
| quantity           |
| buy_price          |<---------->+-----------------+
| coin_id            |            |  Coins         |
| user_id            |            +-----------------+
+--------------------+            | id              |
                                 | symbol          |
+--------------------+            | ...             |
| Withdrawals        |<---------->+-----------------+
|--------------------|
| id                 |
| status             |
| amount             |
| user_id            |
| date               |
+--------------------+

+--------------------+
| Watchlists         |
|--------------------+
| id                 |
| user_id            |
+--------------------+
         |
         |
         v
+--------------------+
| Watchlist_Coins    |
|--------------------+
| watchlist_id       |
| coin_id            |
+--------------------+

+---------------------+           +---------------------+
|   VerificationCodes |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| otp                 |
| user_id             |
| email               |
| mobile              |
| verification_type   |
+---------------------+

+---------------------+           +---------------------+
|  TradingHistories   |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| selling_price       |
| buying_price        |
| coin_id             |
| user_id             |
+---------------------+

+---------------------+           +---------------------+
|    PaymentOrders    |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| amount              |
| status              |
| payment_method      |
| user_id             |
+---------------------+

+---------------------+           +---------------------+
|   PaymentDetails    |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| account_number      |
| account_holder_name |
| ifsc                |
| bank_name           |
| user_id             |
+---------------------+

+---------------------+           +---------------------+
|        Orders       |<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| user_id             |
| order_type          |
| price               |
| timestamp           |
| status              |
| order_item_id       |
+---------------------+
         |
         |
         v
+---------------------+           +---------------------+
|      OrderItems     |<--------->|        Coins        |
|---------------------|           +---------------------+
| id                  |
| quantity            |
| coin_id             |
| buy_price           |
| sell_price          |
| order_id            |
+---------------------+

+---------------------+             +---------------------+
|    Notifications    | <---------> |        Users        |
|---------------------|             +---------------------+
| id                  |
| from_user_id        |
| to_user_id          |
| amount              |
| message             |
+---------------------+

+---------------------+           
|   MarketChartData   |
|---------------------|
| id                  |
| timestamp           |
| price               |
+---------------------+

+---------------------+           +---------------------+
| ForgotPasswordTokens|<--------->|        Users        |
|---------------------|           +---------------------+
| id                  |
| user_id             |
| otp                 |
| verification_type   |
| send_to             |
+---------------------+

```

## Architecture

[![Screenshot-2025-08-15-183439.png](https://i.postimg.cc/fbRkhBZS/Screenshot-2025-08-15-183439.png)](https://postimg.cc/5XDfB5Xf)
## Screenshots

### HomePage

[![Screenshot-2025-08-15-180341.png](https://i.postimg.cc/y8Qs0B4W/Screenshot-2025-08-15-180341.png)](https://postimg.cc/fV9GhGbh)

### Search

[![Screenshot-2025-08-15-180455.png](https://i.postimg.cc/br3F4yRt/Screenshot-2025-08-15-180455.png)](https://postimg.cc/SYYrMp3S)

### History
[![Screenshot-2025-08-15-180516.png](https://i.postimg.cc/FFByCkyx/Screenshot-2025-08-15-180516.png)](https://postimg.cc/4npHmdFK)

### Watchlist
[![Screenshot-2025-08-15-180537.png](https://i.postimg.cc/3Rbvqzvw/Screenshot-2025-08-15-180537.png)](https://postimg.cc/mzCkzXVx)

### Wallet

[![Screenshot-2025-08-15-180613.png](https://i.postimg.cc/3xKgfsSg/Screenshot-2025-08-15-180613.png)](https://postimg.cc/xc4Jc4SC)

### Payment Details
[![Screenshot-2025-08-15-181028.png](https://i.postimg.cc/XY7CkwqL/Screenshot-2025-08-15-181028.png)](https://postimg.cc/GHVtcTkT)


### RazorPay

[![Screenshot-2025-08-15-192029.png](https://i.postimg.cc/mrN9R8PQ/Screenshot-2025-08-15-192029.png)](https://postimg.cc/nsrrGKYz)

[![Screenshot-2025-08-15-192423.png](https://i.postimg.cc/HjDWr1Kj/Screenshot-2025-08-15-192423.png)](https://postimg.cc/7J9rRdqy)


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

### General
APP_NAME=trading-platform
SERVER_PORT=5454

### MySQL Database
DB_URL=jdbc:mysql://localhost:3306/DB_NAME
DB_USER=root
DB_PASS=YOUR_DB_PASSWORD
DB_DRIVER_CLASS=com.mysql.cj.jdbc.Driver
DB_HIBERNATE_DDL_AUTO=update

### Mail Configuration
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=YOUR_EMAIL
MAIL_PASSWORD=YOUR_EMAIL_PASSWORD
MAIL_SMTP_AUTH=true
MAIL_SMTP_STARTTLS_ENABLE=true

### Stripe Payment Gateway
STRIPE_API_KEY=YOUR_STRIPE_API_KEY

### Razorpay Payment Gateway
RAZORPAY_API_KEY=YOUR_RAZORPAY_API_KEY
RAZORPAY_API_SECRET=YOUR_RAZORPAY_API_SECRET

### CoinGecko API
COINGECKO_API_KEY=YOUR_COINGECKO_API_KEY

### Gemini API
GEMINI_API_KEY=YOUR_GEMINI_API_KEY

### Google OAuth2 (optional)
GOOGLE_CLIENT_ID=YOUR_GOOGLE_CLIENT_ID
GOOGLE_CLIENT_SECRET=YOUR_GOOGLE_CLIENT_SECRET



## Installation

Install my-project with npm

Frontend
```bash
  npm i
  npm run dev
```

backend
```bash
  Run application.java
```
    
