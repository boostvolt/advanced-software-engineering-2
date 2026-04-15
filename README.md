# ASE – AI-Assisted Software Engineering (Team 08)

Project for the Advanced Software Engineering 2 (ASE2) course. We investigate **the effects of AI-assisted software engineering on code quality and security** in real-world projects, and apply one existing solution to an open source case study.

The Task 1.3 draft submitted on Sunday Apr 12 is at [task-1-research/draft-submission.md](task-1-research/draft-submission.md). The full course brief is in [task-spec.md](task-spec.md).

## Deadlines

| Date | Deliverable | Where |
|---|---|---|
| **Sun 2026-04-12, 23:59** | Task 1.3 draft (summary of Tasks 1.1 and 1.2) + team registration | Moodle |
| **Tue 2026-05-05, 23:59** | Short report (Task 3 — **mandatory**, no grade without it) | Moodle |
| **Tue 2026-05-19, 23:59** | Final submission: short report, presentation, discussion slide, code repo link | Moodle |

## Weekly plan

_The team works on everything together. Budget: about 4 to 6 hours per week, total. Each week is one focused session._

#### Week 1 — Apr 6–12
- [x] Register team on Moodle
- [x] Read and sign off on the Task 1 files together
- [x] **Submit Task 1.3 draft on Moodle (Sun Apr 12)**

#### Week 2 — Apr 13–19
- [ ] **Check-In 1 with lecturer (Wed Apr 15): discuss draft, get feedback**
- [ ] Compare candidate tools (CodeRabbit, Semgrep, Snyk Code, Aikido, Copilot PR review, SonarQube) and document why each fits or doesn't
- [ ] Pick the tool and the open source repo
- [ ] Set up the case study repo under `task-2-case-study/implementation/`

#### Week 3 — Apr 20–26
- [ ] **Check-In 2 with lecturer (Wed Apr 22): present tool and repo choice**
- [ ] Run the tool against the case study repo
- [ ] Save results and notes in `task-2-case-study/results/`

#### Week 4 — Apr 27–May 3
- [ ] **Check-In 3 with lecturer (Wed Apr 29): present preliminary results**
- [ ] Write the short report draft (weave the reflection into the report, not separate)
- [ ] Start slides outline

#### Week 5 — May 4–10
- [ ] Polish the short report and export to PDF
- [ ] **Submit short report on Moodle (Tue May 5)**
- [ ] Wed May 6 class session: read other teams' reports, get assigned discussion report
- [ ] Build slides and prepare live demo of the tool

#### Week 6 — May 11–17
- [ ] Finish slides, activity materials, and discussion slide
- [ ] Rehearsal
- [ ] **Presentation day: Wed May 13**

#### Week 7 — May 18–19
- [ ] Final pass on all deliverables
- [ ] **Submit all deliverables on Moodle (Tue May 19)**

## Generate PDF

```bash
pandoc <input>.md -o <output>.pdf --pdf-engine=xelatex -V geometry:margin=1in -V fontsize=11pt -V header-includes:'\usepackage{fancyhdr}\pagestyle{fancy}\fancyhead{}\fancyhead[C]{daotro01, matamar, galinpab, kottjan1}\fancyfoot{}\fancyfoot[C]{\thepage}'
```

Requires `pandoc` and `basictex` (`brew install pandoc basictex`).

## Authors

- Dao Trong-Nghia (daotro01)
- Mata Marco (matamar)
- Galindo Lopez Pablo Emiliano (galinpab)
- Jan Kott (kottjan1)
