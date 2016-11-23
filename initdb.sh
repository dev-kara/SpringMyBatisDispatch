sudo -u postgres psql -c "create database test1;create database test2;"
sudo -u postgres psql -d test1 -c "create table t_test(id serial, name text);"
sudo -u postgres psql -d test2 -c "create table t_test(id serial, name text);"
