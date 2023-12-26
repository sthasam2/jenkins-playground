up:
	@docker compose -p jenk -f docker-compose.yml up -d --build

down:
	@docker compose -p jenk down

restart:
	@$(MAKE) down
	@$(MAKE) up
