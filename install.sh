PROJECT=projects/constitucion
echo ---------------------------------------
echo INSTALACION
echo Proyecto 'constitucion'
echo Directorio: $PROJECT
echo ---------------------------------------

sudo service constitucion stop
git pull origin master
mvn -f $PROJECT clean package
sudo service constitucion start
