-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
    ('uno', 'asdf1234', 'Uno', 'uno@mail.com', 'I am Uno.', now(), 'uno', now(), 'uno');

-- 게시판
insert into article (title, content, hashtag, created_by, modified_by, created_at, modified_at) values ('Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', 'Jourdain', null, 'Joelynn', 'Stevy', '2022-06-08 16:53:12', '2022-07-17 14:43:10');

-- 댓글
insert into article_comment (article_id,  content, created_by, modified_by, created_at, modified_at) values ('1','cp3','Joelynn', 'Stevy', '2022-06-08 16:53:12', '2022-07-17 14:43:10');
insert into article_comment (article_id,  content, created_by, modified_by, created_at, modified_at) values ('1','cp4','Joelynn', 'Stevy', '2022-06-08 16:53:12', '2022-07-17 14:43:10');
