INSERT INTO cards(card_number, card_status, bank_account_id)
SELECT
		(REVERSE(c.full_name)) as card_number,
        ('Active') as card_status,
        (c.id) as bank_account_id
FROM clients as c
WHERE c.id BETWEEN 191 AND 200;