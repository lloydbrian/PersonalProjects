$ git pull --rebase origin 			        

Mary's local repo
purple: origin/master, changed by John: his 2 commits, and fetched locally
white: Mary's master: her 2 commits BEFORE synchronization
cyan: Mary's master AFTER rebase sync has her 2 commits on top of John's


Commands to Overwrite Local Files:-
Use the following command to force overwrite local files from remote repository. We are assuming you are downloading changes from remote master branch.

$ git fetch --all
$ git reset --hard origin/master

To download changes from some other branch use the following command.
$ git reset --hard origin/other_branch


Hi APIDB Team - If you want to overwrite your local working branch to the latest sprint1 code baseline in github which includes approved pull requests. You can follow these steps:
```
1. make sure you are in your branch.
2. $ git branch -a
3. should show for example justin-1
4. $ git fetch --all
5. $ git reset --hard origin/sprint1
6. $ git pull --rebase origin
7. make changes following the regular git workflow
```

Disclaimer: The ideal process is still creating a new branch every time you make changes/enhancements. The baseline code of this process would still be sprint1 with approved pull requests. The process above is when you just want your current local branch to be overwritten with what is the latest from github.
