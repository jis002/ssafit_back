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

/* 더미데이터
INSERT INTO `videos` (title, fitPartName, youtubeId, channelName, viewCnt)
VALUES 
("가나다 영상제목", "파트너이름", "myNjmnvI6x0", "채널이름이야", 1);

INSERT INTO `reviews` (title, writer, content, videoId)
VALUES
("리뷰 제목입니다", "리뷰작성자이름", "리뷰 내용입니다 리뷰 내용입니다. 300자 제한이 있어요", 1);
*/


SELECT * FROM videos;
SELECT * FROM reviews;