Delimiter //
CREATE PROCEDURE 'getSurNameByID' (in pid int, out pSurname(20))
BEGIN
  SELECT surname into pSurname
  FROM clients
  WHERE id = pid;
END ;