# VideoStore

The VideoStore example from Martin Fowler's Refactoring, and from Episode 3 of cleancoders.com

I have forked a [copy of uncle Bob's original repo](https://github.com/unclebob/videostore) and set it up
in the initial state but set up as a gradle project and added a noddy github actions pipeline that will run
the tests when any code is pushed.

It is intended to be used for forking to perform training / mentoring exercises.

## Useful Commands

```gradle
// cleans build directories
// formats code
// builds code
// runs tests
// checks for gradle issues
// checks dependency versions
./gradlew clean dependencyUpdates lintGradle spotlessApply build
```