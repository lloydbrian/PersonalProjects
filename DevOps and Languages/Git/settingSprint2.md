## Fetch all and checkout sprint2
```
$ git fetch --all
$ git checkout sprint2
```

## Verify and you should see something like this
```
Branch 'sprint2' set up to track remote branch 'sprint2' from 'origin'.
Switched to a new branch 'sprint2'
```

## Verify remote info
```
$ git remote show origin
* remote origin
  Fetch URL: https://github.com/unh-projects-fall-2018/flashcourses.git
  Push  URL: https://github.com/unh-projects-fall-2018/flashcourses.git
  HEAD branch: master
  Remote branches:
    campbell-1 tracked
    campbell-2 tracked
    jim-1      tracked
    jim-1.5    tracked
    justin-1   tracked
    lloyd-1    tracked
    lloyd-2    tracked
    master     tracked
    sprint1    tracked
    sprint2    tracked
  Local branches configured for 'git pull':
    master  merges with remote master
    sprint2 merges with remote sprint2
  Local refs configured for 'git push':
    master  pushes to master  (up to date)
    sprint2 pushes to sprint2 (up to date)
```

## Create a new branch for yourself off sprint2
```
$ git checkout -b <your_local_branch_name>
```

## When ready do a git push so it will show at github
```
$ git push -u origin <your_local_branch_name>
```
