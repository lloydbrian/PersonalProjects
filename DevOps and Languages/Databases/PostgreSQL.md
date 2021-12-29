## Start Postgres (assuming default directories) in MAC:
```
$ pg_ctl -D /opt/homebrew/var/postgres -l /opt/homebrew/var/postgres/logs/server.log start
```

## Stop Postgres:
```
pg_ctl -D /opt/homebrew/var/postgres stop -s -m fast
```

### Useful links
https://www.codementor.io/@engineerapart/getting-started-with-postgresql-on-mac-osx-are8jcopb
