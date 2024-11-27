-- Tạo cơ sở dữ liệu
CREATE DATABASE ClothesShop;
GO

-- Sử dụng cơ sở dữ liệu
USE ClothesShop;
GO

-- Xóa các bảng nếu tồn tại
IF OBJECT_ID('OrderItem', 'U') IS NOT NULL DROP TABLE OrderItem;
IF OBJECT_ID('Orders', 'U') IS NOT NULL DROP TABLE Orders;
IF OBJECT_ID('Payments', 'U') IS NOT NULL DROP TABLE Payments;
IF OBJECT_ID('Products', 'U') IS NOT NULL DROP TABLE Products;
IF OBJECT_ID('Suppliers', 'U') IS NOT NULL DROP TABLE Suppliers;
IF OBJECT_ID('Categories', 'U') IS NOT NULL DROP TABLE Categories;
IF OBJECT_ID('Types', 'U') IS NOT NULL DROP TABLE Types;
IF OBJECT_ID('Users', 'U') IS NOT NULL DROP TABLE Users;

-- Tạo bảng Users
CREATE TABLE Users (
    id INT NOT NULL IDENTITY(1,1),
    firstname NVARCHAR(30) NOT NULL,
    lastname NVARCHAR(30) NOT NULL,
    email NVARCHAR(50) NOT NULL,
    avatar VARCHAR(200) NOT NULL,
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(64) NOT NULL,
    address NVARCHAR(200) NOT NULL,
    phone NVARCHAR(15) NOT NULL,
    roleid INT NOT NULL,
    status BIT NOT NULL
);
GO

-- Tạo bảng Types
CREATE TABLE Types (
    id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100)
);
GO

-- Tạo bảng Categories
CREATE TABLE Categories (
    categoryid INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    categoryname NVARCHAR(30),
    type_id INT FOREIGN KEY REFERENCES Types(id)
);
GO

-- Tạo bảng Suppliers
CREATE TABLE Suppliers (
    supplierid INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    suppliername NVARCHAR(100),
    supplierimage VARCHAR(255) NOT NULL
);
GO

-- Tạo bảng Products
CREATE TABLE Products (
    id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    productname NVARCHAR(MAX) NOT NULL,
    supplierid INT FOREIGN KEY REFERENCES Suppliers(supplierid) ON DELETE SET NULL ON UPDATE CASCADE,
    categoryid INT FOREIGN KEY REFERENCES Categories(categoryid) ON DELETE SET NULL ON UPDATE CASCADE,
    size VARCHAR(40) NOT NULL,
    stock INT NOT NULL,
    [description] NVARCHAR(MAX),
    [images] VARCHAR(255) NOT NULL,
    [colors] NVARCHAR(255) NOT NULL,
    releasedate DATE NOT NULL,
    discount FLOAT,
    unitSold INT,
    price MONEY NOT NULL,
    status BIT NOT NULL,
    typeid INT NOT NULL FOREIGN KEY REFERENCES Types(id) ON DELETE CASCADE ON UPDATE CASCADE
);
GO

-- Tạo bảng Payments
CREATE TABLE Payments (
    paymentid INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    payment_method NVARCHAR(30)
);
GO

-- Tạo bảng Orders
CREATE TABLE Orders (
    order_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    orderdate DATETIME,
    totalprice DECIMAL(10,2),
    paymentid INT NOT NULL FOREIGN KEY REFERENCES Payments(paymentid),
    username VARCHAR(30) NOT NULL FOREIGN KEY REFERENCES Users(username),
    status BIT NOT NULL
);
GO

-- Tạo bảng OrderItem
CREATE TABLE OrderItem (
    order_item_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    quantity INT,
    price DECIMAL(10,2),
    product_id INT NOT NULL FOREIGN KEY REFERENCES Products(id) ON DELETE CASCADE,
    order_id INT NOT NULL FOREIGN KEY REFERENCES Orders(order_id)
);
GO
