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

_Budget: about 3 to 4 hours per person per week. Independent tasks are split across members; shared tasks are done together._

#### Week 1 — Apr 6–12
- [x] Register team on Moodle
- [x] Create draft repository structure (galingpab)
- [x] Discuss topic, motivation, challenges, and approach (all)
- [x] Create draft itself (matamar)
- [x] Read and sign off on the Task 1 draft together (all)
- [x] **Submit Task 1.3 draft on Moodle (Sun Apr 12)**

#### Week 2 — Apr 13–19
- [x] **Check-In 1 with lecturer (Wed Apr 15): discuss draft, get feedback**
  - Feedback: back up claims (e.g. "AI code has high severity vulnerabilities") with sources AND later case study
  - Teacher confirmed the human-vs-AI approach leveraging the first-semester Java Catan game
- [ ] **matamar:** Enrich Task 1 draft with sources for unsubstantiated claims + rebuild the first-semester Java Catan game with Claude Opus (human vs AI comparison)
- [ ] **kottjan01:** Survey tools (Dependabot, Jules, GitHub Security Agent, SonarQube, etc.), document what each solves and misses, find an OSS project to test them on
- [ ] **galinpab:** Draft a concept for a class activity (~5 min, interactive, original)
- [ ] **daotro01:** Make his code review activity idea concrete (show good/bad code, class reviews it, compare with AI verdict; ~5 min)
- daotro01 limited availability (military).

#### Week 3 — Apr 20–26
- [ ] **Check-In 2 with lecturer (Wed Apr 22): present tool and repo choice**
- [ ] **matamar + kottjan01:** Pick the best tool from the survey and run it on both Catan implementations (human-made vs Claude Opus generated)
- [ ] **daotro01:** Help run tools and document scan results in `task-2-case-study/results/`
- [ ] Discuss both activity drafts as a team (daotro01's code review activity + galinpab's idea) and refine them (all)

#### Week 4 — Apr 27–May 3
- [ ] **Check-In 3 with lecturer (Wed Apr 29): present preliminary results**
- [ ] **matamar:** Write the short report draft (Tasks 1 + 2 combined, 2 to 5 pages)
- [ ] **daotro01:** Write Task 2 reflection docs (decision rationale, difficulties, tradeoffs, limitations, future work)
- [ ] **kottjan01:** Review report draft for technical accuracy on tool findings
- [ ] **daotro01 + galinpab:** Make both activities concrete and presentation-ready

#### Week 5 — May 4–10
- [ ] **matamar:** Polish short report, export to PDF, **submit on Moodle (Tue May 5)**
- [ ] Wed May 6 class session: read other teams' reports, get assigned discussion report (all)
- [ ] **kottjan01:** Build presentation slides and prepare live demo of the tool
- [ ] **daotro01:** Read assigned team's report, draft discussion slide (Task 6)
- [ ] **daotro01 + galinpab:** Finalize both activities for presentation day

#### Week 6 — May 11–17
- [ ] Rehearsal (all)
- [ ] **kottjan01:** Finish slides
- [ ] **daotro01 + galinpab:** Finish activity materials
- [ ] **daotro01:** Finish discussion slide
- [ ] **Presentation day: Wed May 13**

#### Week 7 — May 18–19
- [ ] Final pass on all deliverables (all)
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
