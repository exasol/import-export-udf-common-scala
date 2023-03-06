# Developer Guide

This guide provides development workflows that are used to develop and maintain
the import-export-udf-common-scala and the projects based on it. It is intended
for those who wish to address the issues, merge a pull request, perform release
or deep dive into the codebase of the project.

## Contributing

Contributions to the import-export-udf-common-scala projects are very welcome!

Please feel free to report a bug, suggest an idea for a feature, or ask a
question about the code.

Please keep in mind that contributions are not only pull requests. They can be
any helpful comment on issues, improving documentation, enhancing the build
process and many other tasks.

### Getting in Touch

Please feel free to report a bug, suggest an idea for a feature, or ask a
question about the code.

You can create an issue using [Github issues][gh-issues] or follow a standard
fork and pull process to contribute a code via [Github pull requests][gh-pulls].

If you do not know where to start, please have a look at [open
issues][open-issues]. You can choose the ones that interest you the most. If you
are new to the project, check out the issues labeled as
[good-first-issue][first-issue].

### Submitting a Pull Request

Once you have found an interesting feature or issue to contribute, you can
follow the steps below to submit your patches.

- Create a new feature branch, `git checkout -b "cool-new-feature"`
- Code
- Write tests for changes
- Update documentation if needed
- **Make sure everything is working**, run `mvn clean verify`
- If everything is okay, commit and push to your fork
- [Submit a pull request][submit-pr]
- Let us work together to get your changes reviewed
- Merge into master or development branches

If your commit fixes any particular issue, please specify it in your commit
message as `Fixes issue [issue number]`. For example, `Fixes issue #29`.

Some best practices when creating a pull request:

- Rebase or update
- Squash your commits
- Reword your commits
- Write clear commit messages

## Development Environment

You need to have Java version 11 or above installed on your development
machine.

Additionally, we assume you have some experience doing Scala development. If you
have any questions in general or about the development process, please feel free
to get in touch.

## Building the Project

First clone a local copy of the repository:

```bash
git clone https://github.com/exasol/import-export-udf-common-scala.git
```

Then run the end-to-end build process:

```sh
mvn clean verify
```

## Checking the Dependency Updates

It is important to keep the dependencies up to date.

You can check out if any of dependencies or plugins have new versions, by
running the following commands.

Check if any plugins have new versions:

```bash
mvn versions:display-plugin-updates -U
```

Check if any dependencies have new versions:

```bash
mvn versions:display-dependency-updates -U
```

### Dependency Tree and Artifact Eviction

You can check the dependency tree by running the command below:

```bash
mvn dependency:tree
```

## Conclusion

This guide is expected to change and evolve with the changes to the project.
Any pull requests to keep this document updated are very much appreciated!

[gh-issues]: https://github.com/exasol/import-export-udf-common-scala/issues
[gh-pulls]: https://github.com/exasol/import-export-udf-common-scala/pulls
[gh-releases]: https://github.com/exasol/import-export-udf-common-scala/releases
[submit-pr]: https://github.com/exasol/import-export-udf-common-scala/compare
[open-issues]: https://github.com/exasol/import-export-udf-common-scala/issues
[first-issue]: https://github.com/exasol/import-export-udf-common-scala/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22
[import-export-udf]: https://docs.exasol.com/loading_data/user_defined_import_export_using_udfs.htm
