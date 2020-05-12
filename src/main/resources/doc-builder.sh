#!/bin/bash

echo "Generate Documents with feature files in html, doc & excel format"

appDirectory=$(pwd)
featureDirectory="$appDirectory/features"
outputDirectory="$appDirectory/../../../target/document"

rm -rf "$outputDirectory"

picklesDirectory="$appDirectory/doc-builder"

$picklesDirectory/pickles.exe --feature-directory="$featureDirectory" --output-directory="$outputDirectory"
$picklesDirectory/pickles.exe --feature-directory="$featureDirectory" --output-directory="$outputDirectory" --df=Word
$picklesDirectory/pickles.exe --feature-directory="$featureDirectory" --output-directory="$outputDirectory" --df=Excel

wait
#exit