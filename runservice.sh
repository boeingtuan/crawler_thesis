rm -rf dist
mkdir -p dist
cp target/ReviewCrawler.jar dist
cp -r target/lib dist/lib

echo "Application Running"
java -jar -Dlog4j.configuration=file:conf/log4j.properties -Dconfig.file=conf/application.conf dist/ReviewCrawler.jar 