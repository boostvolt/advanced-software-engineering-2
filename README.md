# ASE – AI-Assisted Software Engineering (Team 08)

Project for the Advanced Software Engineering 2 (ASE2) course. We investigate **the effects of AI-assisted software engineering on code quality and security** in real-world projects, and apply one existing solution to an open source case study.

The Task 1.3 draft submitted on Sunday Apr 12 is at [task-1-research/draft-submission.md](task-1-research/draft-submission.md). The full course brief is in [task-spec.md](task-spec.md).

## Deadlines

| Date | Deliverable | Where |
|---|---|---|
| **Sun 2026-04-12, 23:59** | Task 1.3 draft (summary of Tasks 1.1 and 1.2) + team registration | Moodle |
| **Wed 2026-05-06, 23:59** | Short report (Task 3 — **mandatory**, no grade without it) | Moodle |
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
- [x] **matamar:** Enrich Task 1 draft with sources for unsubstantiated claims
- [x] **daotro01:** First version of code review activity drafted
- [x] **galinpab:** Activity idea proposed ("let AI explain the code")
- Remaining work below moved into Week 3.

#### Week 3 — Apr 20–26 
- [x] **Check-In 2 with lecturer (Wed Apr 22): present tool and repo choice**
  - Teacher approved the two-phase Task 2 (Node.js bench justifies tool, Catan tests the claim)
  - Teacher approved full catan task scope for both Catan impls
- [x] **matamar:** Rebuild the first-semester Java Catan game with Claude Opus via `task-2-case-study/implementation/PROMPT.md`. Output in `catan-ai/`, `mvn test` passes 8/8, `GENERATION_LOG.md` records the reflection.
- [x] **matamar:** Start the short report draft in `task-3-report/short-report-draft.md` — Task 1 content enriched, Case study section added with methodology and two-phase tool approach. Findings and reflection stubbed until scans arrive.
- [x] **kottjan01:** Evaluated candidate code-analysis tools against a Node.js bench project. **Decision: SonarQube** for the Catan human-vs-AI code analysis comparison. Documentation of the comparison and the SonarQube run on Catan moves to Week 4.
- [x] **daotro01 + galinpab:** Activity discussion. Decision: two activities won't fit in the time budget, so we run **one** 10-minute activity, prepared by **daotro01**. galinpab pivots to preparing the presentation structure.

#### Week 4 — Apr 27–May 3
- [x] **Check-In 3 with lecturer (Wed Apr 29): present preliminary results**
  - Feedback: report should be **to the point, not a full academic report**. Preferred length **5 to 10 pages** (overrides the 2 to 5 pages in `task-spec.md`).
- [ ] **kottjan01:** Document the tool comparison results in `task-2-case-study/tool-survey/` and apply **SonarQube** to both Catan implementations (human-made vs Claude Opus generated). Document the findings in `task-2-case-study/results/`.
- [ ] **matamar:** Finalize the short report once kottjan01's SonarQube findings are in. Tasks 1 + 2 combined, **5 to 10 pages**, to-the-point style (not a full academic report).
- [ ] **galinpab:** Prepare the presentation structure — a skeleton ready to be filled with the report content and case-study results next week.
- [ ] **daotro01:** Prepare the 10-minute class activity.

#### Week 5 — May 4–10
- [ ] **Wed May 6, first 2 lessons:** Show the report to the teacher and apply any last feedback. *(Last 2 lessons are the ABB guest lecture — onsite presence expected.)*
- [ ] **Wed May 6, 23:59:** Submit the short report on Moodle.
- [ ] Wed May 6 class session: read other teams' reports, get assigned discussion report (all).
- [ ] **galinpab + kottjan01:** Fill the presentation structure with the actual report and case-study results; prepare the live demo of SonarQube.
- [ ] **daotro01:** Read assigned team's report, draft discussion slide (Task 6).
- [ ] **daotro01:** Finalize the activity for presentation day.

#### Week 6 — May 11–17
- [ ] Rehearsal (all)
- [ ] **galinpab + kottjan01:** Finish slides
- [ ] **daotro01:** Finish activity materials
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
