#!/usr/bin/env bash

set -o errexit
set -o nounset
set -o pipefail

if ! command -v xmlstarlet &> /dev/null
then
    echo "xmlstarlet tool is not available, please install it to continue."
    exit 1
fi

readonly RELEASE_POM=release-pom.xml
echo "Copying original POM file to $RELEASE_POM"
cp pom.xml "$RELEASE_POM"

CURRENT_VERSION=$(mvn --file "$RELEASE_POM" -q -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive exec:exec)

echo "Updating artifactId value for release POM $RELEASE_POM"
xmlstarlet edit -L --ps -N pom="http://maven.apache.org/POM/4.0.0" \
    --update "/pom:project/pom:artifactId" \
    --value "import-export-udf-common-scala_\${scala.compat.version}" "$RELEASE_POM"

