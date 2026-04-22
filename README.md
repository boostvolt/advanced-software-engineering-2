# ASE – AI-Assisted Software Engineering (Team 08)

Project for the Advanced Software Engineering 2 (ASE2) course. We investigate **the effects of AI-assisted software engineering on code quality and security** in real-world projects, and apply one existing solution to an open source case study.

The Task 1.3 draft submitted on Sunday Apr 12 is at [task-1-research/draft-submission.md](task-1-research/draft-submission.md). The full course brief is in [task-spec.md](task-spec.md).

## Deadlines

| Date | Deliverable | Where |
|---|---|---|
| **Sun 2026-04-12, 23:59** | Task 1.3 draft (summary of Tasks 1.1 and 1.2) + team registration | Moodle |
| **Tue 2026-05-12, 23:59** | Short report (Task 3 — **mandatory**, no grade without it) | Moodle |
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
  - Teacher approved one-shot agentic Claude Opus generation as the AI protocol
  - Teacher approved full Teilaufgabe 1 + 2 + 3 Robber scope for both Catan impls
- [ ] **matamar:** Rebuild the first-semester Java Catan game with Claude Opus via `task-2-case-study/implementation/PROMPT.md`.
- [x] **matamar:** Start the short report draft in `task-3-report/short-report-draft.md` — Task 1 content enriched, Case study section added with methodology and two-phase tool approach. Findings and reflection stubbed until scans arrive.
- [ ] **kottjan01:** Evaluate GitHub's security stack (Dependabot, Code Security, Secret Protection, Copilot code review / Dependency Review) against a Node.js bench project. Two deliverables: (a) capability comparison table for the presentation, (b) one tool selected for the Catan case study. Selection criterion: among tools that actually produce findings on a Java codebase like Catan, which is strongest.
- [ ] **daotro01 + galinpab:** Finalize both activities (daotro01's code review + galinpab's "AI explains code"), team discussion to refine. Target: presentation-ready by Check-In 3 (Wed Apr 29).

#### Week 4 — Apr 27–May 3
- [ ] **Check-In 3 with lecturer (Wed Apr 29): present preliminary results**
- [ ] **matamar + kottjan01:** Apply the tool(s) kottjan01 selected on the Node.js bench to both Catan implementations (human-made vs Claude Opus generated). Node.js justifies the tool choice; Catan tests the human-vs-AI claim.
- [ ] **daotro01:** Help run tools and document scan results in `task-2-case-study/results/`
- [ ] **matamar + galinpab:** Finish the short report draft (Tasks 1 + 2 combined, 2 to 5 pages). Draft already begun in Week 3; galinpab picks up polish and structure while matamar focuses on the Task 2 results section as scans arrive.
- [ ] **daotro01:** Write Task 2 reflection docs (decision rationale, difficulties, tradeoffs, limitations, future work)
- [ ] **kottjan01:** Review report draft for technical accuracy on tool findings
- [ ] **daotro01 + galinpab:** Apply any feedback from Check-In 3 to the activities

#### Week 5 — May 4–10
- [ ] **matamar + galinpab:** Finish writing the short report (Tasks 1 + 2 combined, 2 to 5 pages)
- [ ] Wed May 6 class session: read other teams' reports, get assigned discussion report (all) — confirm whether this class session still happens May 6 given the new May 12 report deadline
- [ ] **kottjan01:** Build presentation slides and prepare live demo of the tool
- [ ] **daotro01:** Read assigned team's report, draft discussion slide (Task 6)
- [ ] **daotro01 + galinpab:** Finalize both activities for presentation day

#### Week 6 — May 11–17
- [ ] **matamar:** Polish short report, export to PDF, **submit on Moodle (Tue May 12)**
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
