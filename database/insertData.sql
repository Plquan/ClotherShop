-- Insert Users
INSERT INTO Users 
VALUES 
(N'Jung', N'Kim', 'user@gmail.com', 'view/assets/home/img/users/user.jpg', 'user1', '12345', N'Ha Noi', '0981347469', 2, 0),
(N'admin', N'', 'admin@gmail.com', 'view/assets/home/img/users/user.jpg', 'admin', '12345', N'Quận 9', '0981347469', 1, 1),
(N'Phùng', N'Thành', 'thanh@gmail.com', 'view/assets/home/img/users/1.jpg', 'phuuthanh2003', '12345', N'60 Nguyễn Văn Trỗi, Phường 2, TP.Bảo Lộc', '0707064154', 1, 1),
(N'Bé', N'Moon', 'Moon123@gmail.com', 'view/assets/home/img/users/user1.jpg', 'user2', '12345', N'13 Hoàng Hữu Nam, Phường 2, TP.Bảo Lộc', '06868686868', 2, 1),
(N'User', N'3', 'user3@gmail.com', 'view/assets/home/img/users/user3.jpg', 'user3', '12345', N'USA', '06868686868', 2, 1);

-- Insert Types
INSERT INTO Types 
VALUES 
(N'Áo'),
(N'Quần'),
(N'Phụ kiện');

-- Insert Categories
INSERT INTO Categories 
VALUES 
(N'Áo sơ mi', 1),
(N'T-Shirt', 1),
(N'Sweatshirt', 1),
(N'Áo khoác', 1),
(N'Hoodies', 1),
(N'Quần short', 2),
(N'Quần thun', 2),
(N'Quần jean', 2),
(N'Áo Polo', 1),
(N'Mũ', 3),
(N'Balo', 3),
(N'Giày', 3),
(N'Áo bóng đá', 1),
(N'Kính', 3);

-- Insert Suppliers
INSERT INTO Suppliers 
VALUES 
('Adidas', 'view/assets/home/img/suppliers/1.jpg'),
('Nike', 'view/assets/home/img/suppliers/2.jpg'),
('Louis Vuitton', 'view/assets/home/img/suppliers/3.jpg'),
('Channel', 'view/assets/home/img/suppliers/4.jpg'),
('BoBui', 'view/assets/home/img/suppliers/5.jpg'),
('4MEN', 'view/assets/home/img/suppliers/6.jpg');

-- Insert Products
INSERT INTO Products 
VALUES 
(N'ÁO KHOÁC REGULAR TECHNICAL', 6, 4, 'S,M', 5, N'Áo sơ mi khoác bằng cotton dệt chéo, có cổ, nẹp khuy liền và cầu vai phía sau. Túi ngực mở, tay dài có nẹp tay áo và măng sét cài khuy cùng vạt tròn.', 'view/assets/home/img/products/1-1.jpg view/assets/home/img/products/1-2.jpg', N'Đen', '2021-12-01', 0.4, 5, 249.000, 1, 1),
(N'ÁO SƠ MI TRƠN TAY NGẮN', 2, 1, 'S,M,L,XXL', 15, N'Áo Sơ Mi Tay Ngắn Nam Cotton Form Regular đem đến item tối giản với phong cách tràn đầy năng lượng, trẻ trung. Áo được làm từ chất liệu cotton với form áo suông, không ôm vào phần cơ thể đem đến sự thoải mái, nhẹ nhàng. Thân áo suông thẳng, thân sau áo có ly tạo nên điểm nổi bật cho áo.', 'view/assets/home/img/products/2-1.jpg view/assets/home/img/products/2-2.jpg', N'Trắng,Đen,Xám', '2022-02-01', 0.37, 76, 179.000, 1, 1),
(N'QUẦN JEANS XANH WASH LASER TÚI SAU FORM SLIM-CROPPED', 6, 8, 'S,M,L', 45, N'Một chiếc jeans xanh Wash Laser túi sau form slim-cropped 4MEN QJ092 trong tủ đồ có thể giúp các chàng trai mix được hàng chục, hàng trăm outfit khác nhau, từ thanh lịch đến bụi bặm cá tính, rồi năng động và tất nhiên luôn toát lên vẻ đẹp trẻ trung và hiện đại. Sở hữu ngay mẫu quần jeans xanh wash laser túi sau form slim-cropped 4MEN QJ092, chất vải mềm mịn và co giãn tốt sẽ rất thích hợp với ai yêu thích jeans.', 'view/assets/home/img/products/3-1.jpg view/assets/home/img/products/3-2.jpg', N'Xanh dương', '2023-11-01', 0, 72, 545.000, 1, 2),
(N'ÁO HOODIE MAY ĐẮP BASIC FORM REGULAR', 5, 4, 'S,M,L', 30, N'Áo nỉ có mũ, form Regular-Fit; Ngực trái áo có hình thêu chữ sử dụng kỹ thuật đắp vải con giống sắc nét ; 2 bên sườn áo may 2 mảng BO đảm bảo đúng form dáng thiết kế và tăng cảm giác thoải mái khi mặc; Áp dụng công nghệ giặt khô trước may hạn chế tình trạng co rút vải.', 'view/assets/home/img/products/4-1.jpg view/assets/home/img/products/4-2.jpg', N'Xanh dương', '2019-11-01', 0.31, 51, 399.000, 1, 1),
(N'ÁO THUN RÃ PHỐI IN HOME IS FORM REGULAR', 6, 2, 'S,M,L', 30, N'Thiết kế áo thun nam basic, cổ tròn form regular tay ngắn trẻ trung, hiện đại. Áo thun nam phối kẻ ngang nam tính, phong cách hiện đại.', 'view/assets/home/img/products/5-1.jpg view/assets/home/img/products/5-2.jpg', N'Nâu', '2019-11-01', 0.17, 21, 315.000, 1, 1),
(N'ÁO SWEATSHIRT BIG LOGO ADIDAS', 1, 3, 'S,M,L,XL', 10, N'Bất kể bạn chuẩn bị tập luyện buổi sáng hay nghỉ ngơi sau một ngày dài, đã có chiếc áo sweatshirt adidas này đồng hành cùng bạn. Chất liệu vải thun da cá siêu dễ chịu cùng cổ tay và gấu áo bo gân giúp bạn luôn thoải mái và duy trì nhiệt độ hoàn hảo trong mọi hoạt động. Hãy diện chiếc áo này và sẵn sàng cho tất cả.', 'view/assets/home/img/products/6-1.jpg view/assets/home/img/products/6-2.jpg', N'Xám,Trắng', '2022-11-01', 0.15, 11, 875.000, 1, 1);

-- Continue the rest of the product insertions similarly...
-- Insert Users
INSERT INTO Users 
VALUES 
(N'Jung', N'Kim', 'user@gmail.com', 'view/assets/home/img/users/user.jpg', 'user1', '12345', N'Ha Noi', '0981347469', 2, 0),
(N'admin', N'', 'admin@gmail.com', 'view/assets/home/img/users/user.jpg', 'admin', '12345', N'Quận 9', '0981347469', 1, 1),
(N'Phùng', N'Thành', 'thanh@gmail.com', 'view/assets/home/img/users/1.jpg', 'phuuthanh2003', '12345', N'60 Nguyễn Văn Trỗi, Phường 2, TP.Bảo Lộc', '0707064154', 1, 1),
(N'Bé', N'Moon', 'Moon123@gmail.com', 'view/assets/home/img/users/user1.jpg', 'user2', '12345', N'13 Hoàng Hữu Nam, Phường 2, TP.Bảo Lộc', '06868686868', 2, 1),
(N'User', N'3', 'user3@gmail.com', 'view/assets/home/img/users/user3.jpg', 'user3', '12345', N'USA', '06868686868', 2, 1);

-- Insert Types
INSERT INTO Types 
VALUES 
(N'Áo'),
(N'Quần'),
(N'Phụ kiện');

-- Insert Categories
INSERT INTO Categories 
VALUES 
(N'Áo sơ mi', 1),
(N'T-Shirt', 1),
(N'Sweatshirt', 1),
(N'Áo khoác', 1),
(N'Hoodies', 1),
(N'Quần short', 2),
(N'Quần thun', 2),
(N'Quần jean', 2),
(N'Áo Polo', 1),
(N'Mũ', 3),
(N'Balo', 3),
(N'Giày', 3),
(N'Áo bóng đá', 1),
(N'Kính', 3);

-- Insert Suppliers
INSERT INTO Suppliers 
VALUES 
('Adidas', 'view/assets/home/img/suppliers/1.jpg'),
('Nike', 'view/assets/home/img/suppliers/2.jpg'),
('Louis Vuitton', 'view/assets/home/img/suppliers/3.jpg'),
('Channel', 'view/assets/home/img/suppliers/4.jpg'),
('BoBui', 'view/assets/home/img/suppliers/5.jpg'),
('4MEN', 'view/assets/home/img/suppliers/6.jpg');

-- Insert Products
INSERT INTO Products 
VALUES 
(N'ÁO KHOÁC REGULAR TECHNICAL', 6, 4, 'S,M', 5, N'Áo sơ mi khoác bằng cotton dệt chéo, có cổ, nẹp khuy liền và cầu vai phía sau. Túi ngực mở, tay dài có nẹp tay áo và măng sét cài khuy cùng vạt tròn.', 'view/assets/home/img/products/1-1.jpg view/assets/home/img/products/1-2.jpg', N'Đen', '2021-12-01', 0.4, 5, 249.000, 1, 1),
(N'ÁO SƠ MI TRƠN TAY NGẮN', 2, 1, 'S,M,L,XXL', 15, N'Áo Sơ Mi Tay Ngắn Nam Cotton Form Regular đem đến item tối giản với phong cách tràn đầy năng lượng, trẻ trung. Áo được làm từ chất liệu cotton với form áo suông, không ôm vào phần cơ thể đem đến sự thoải mái, nhẹ nhàng. Thân áo suông thẳng, thân sau áo có ly tạo nên điểm nổi bật cho áo.', 'view/assets/home/img/products/2-1.jpg view/assets/home/img/products/2-2.jpg', N'Trắng,Đen,Xám', '2022-02-01', 0.37, 76, 179.000, 1, 1),
(N'QUẦN JEANS XANH WASH LASER TÚI SAU FORM SLIM-CROPPED', 6, 8, 'S,M,L', 45, N'Một chiếc jeans xanh Wash Laser túi sau form slim-cropped 4MEN QJ092 trong tủ đồ có thể giúp các chàng trai mix được hàng chục, hàng trăm outfit khác nhau, từ thanh lịch đến bụi bặm cá tính, rồi năng động và tất nhiên luôn toát lên vẻ đẹp trẻ trung và hiện đại. Sở hữu ngay mẫu quần jeans xanh wash laser túi sau form slim-cropped 4MEN QJ092, chất vải mềm mịn và co giãn tốt sẽ rất thích hợp với ai yêu thích jeans.', 'view/assets/home/img/products/3-1.jpg view/assets/home/img/products/3-2.jpg', N'Xanh dương', '2023-11-01', 0, 72, 545.000, 1, 2),
(N'ÁO HOODIE MAY ĐẮP BASIC FORM REGULAR', 5, 4, 'S,M,L', 30, N'Áo nỉ có mũ, form Regular-Fit; Ngực trái áo có hình thêu chữ sử dụng kỹ thuật đắp vải con giống sắc nét ; 2 bên sườn áo may 2 mảng BO đảm bảo đúng form dáng thiết kế và tăng cảm giác thoải mái khi mặc; Áp dụng công nghệ giặt khô trước may hạn chế tình trạng co rút vải.', 'view/assets/home/img/products/4-1.jpg view/assets/home/img/products/4-2.jpg', N'Xanh dương', '2019-11-01', 0.31, 51, 399.000, 1, 1),
(N'ÁO THUN RÃ PHỐI IN HOME IS FORM REGULAR', 6, 2, 'S,M,L', 30, N'Thiết kế áo thun nam basic, cổ tròn form regular tay ngắn trẻ trung, hiện đại. Áo thun nam phối kẻ ngang nam tính, phong cách hiện đại.', 'view/assets/home/img/products/5-1.jpg view/assets/home/img/products/5-2.jpg', N'Nâu', '2019-11-01', 0.17, 21, 315.000, 1, 1),
(N'ÁO SWEATSHIRT BIG LOGO ADIDAS', 1, 3, 'S,M,L,XL', 10, N'Bất kể bạn chuẩn bị tập luyện buổi sáng hay nghỉ ngơi sau một ngày dài, đã có chiếc áo sweatshirt adidas này đồng hành cùng bạn. Chất liệu vải thun da cá siêu dễ chịu cùng cổ tay và gấu áo bo gân giúp bạn luôn thoải mái và duy trì nhiệt độ hoàn hảo trong mọi hoạt động. Hãy diện chiếc áo này và sẵn sàng cho tất cả.', 'view/assets/home/img/products/6-1.jpg view/assets/home/img/products/6-2.jpg', N'Xám,Trắng', '2022-11-01', 0.15, 11, 875.000, 1, 1);

-- Continue the rest of the product insertions similarly...
