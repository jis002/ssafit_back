DROP DATABASE IF EXISTS ssafit_db;
CREATE DATABASE ssafit_db DEFAULT CHARACTER SET utf8mb4;
USE ssafit_db;

DROP TABLE IF EXISTS videos;

CREATE TABLE `videos` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(40) NOT NULL,
  `fitPartName` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `youtubeId` varchar(40) NOT NULL,
  `channelName` varchar(40) NOT NULL,
  `viewCnt` int NOT NULL,
  `img` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS reviews;
CREATE TABLE `reviews` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(40) NOT NULL,
  `writer` varchar(40) NOT NULL,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `createTime` TIMESTAMP DEFAULT now(),
  `videoId` int(10) NOT NULL,
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`videoId`) REFERENCES `videos` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `videos` (title, fitPartName, youtubeId, channelName, viewCnt)
VALUES 
("가나다 영상제목", "파트너이름", "myNjmnvI6x0", "채널이름이야", 0),
("멋지다 건이야~! 브라보!!!", "김지수", "gMaB-fG4u4g", "GOGOGUN", 0),
("프로그래머 건이야!!", "고건", "5MACh6ylf8g", "채널이름이야", 0);

INSERT INTO `reviews` (title, writer, content, videoId)
VALUES
("리뷰 제목입니다", "리뷰작성자이름", "리뷰 내용입니다 리뷰 내용입니다. 300자 제한이 있어요", 1),
("리뷰 1234", "김싸피", "리뷰 내용입니다 아주 멋집니다 그레잇이트", 1),
("리뷰 1234567890", "김싸피", "리뷰 내용입니다 아주 멋집니다 그레잇이트", 1),
("리뷰 화이팅", "김싸피", "리뷰 내용입니다 아주 멋집니다 그레잇이트", 1),
("리뷰 멋지다! BRAVO!!", "짓", "고건은 천재적인 프로그래머 입니다.", 2),
("Perpecto~!! BRAVO!!", "김지수", "고건은 천재적인 프로그래머 입니다.", 2),
("아하하하하하", "익명", "리뷰 내용입니다 리뷰 내용입니다. 300자 제한이 있어요", 3);


SELECT * FROM videos;
SELECT * FROM reviews;