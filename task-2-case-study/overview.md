# Task 2 — Case Study

## What we are doing

We are probing the Task 1 finding that AI generated code carries measurable quality and security debt (Veracode 45% high severity vuln rate and 2.74x more vulnerabilities than human written code, GitClear 4x code clones). The probe is concrete: we take the same specification and produce two implementations of it, then run the same security/quality tool on both and compare findings.

**Specification:** PM1 Projekt 3, the first semester ZHAW Catan assignment. Source PDFs in `spec/`.

**Two implementations:**
- `implementation/catan-human/` — [boostvolt/zhaw-catan](https://github.com/boostvolt/zhaw-catan), a public first semester student team's implementation. Used as the human control.
- `implementation/catan-ai/` — a fresh Java implementation generated in a single agentic Claude Opus session from the consolidated spec. See `implementation/PROMPT.md` for the exact prompt used, preserved verbatim.

Both implementations target the same scope (Teilaufgabe 1 + 2 + 3 with the Robber variant) and share the same fixed library code (`ch.zhaw.hexboard`).

## Folder map

| Folder | Contents | Owner | Week |
|---|---|---|---|
| `spec/` | Original assignment PDFs (Anleitung + Kick-Off). Authoritative spec. | — | — |
| `tool-survey/` | Evaluation of candidate code-analysis tools. Selected: **SonarQube**. | kottjan01 | 3-4 |
| `implementation/` | `SPEC.md`, `PROMPT.md`, `catan-human/`, `catan-ai/`. | matamar | 2 |
| `results/` | SonarQube scan summary and interpretation, plus `structural-comparison.md`. | kottjan01 | 4 |
| `demo/` | Live demo script and materials for presentation day. | kottjan01 + galinpab | 6 |

Reflection (decision rationale, difficulties, tradeoffs, limitations, future work) lives directly in `task-3-report/short-report-draft.md` rather than in separate files — the report is the synthesis and there is no intermediate stage.

## Relationship to Task 3 short report

The short report (`task-3-report/short-report-draft.md`) has a stub Section 4 that will be filled in once this case study produces SonarQube scan results.
