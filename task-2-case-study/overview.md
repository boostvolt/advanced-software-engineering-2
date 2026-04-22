# Task 2 — Case Study

## What we are doing

We are probing the Task 1 finding that AI generated code carries measurable quality and security debt (Veracode 45% high severity vuln rate, GitClear 4x code clones, Snyk 2.74x vulnerability rate in AI co authored PRs). The probe is concrete: we take the same specification and produce two implementations of it, then run the same security/quality tool on both and compare findings.

**Specification:** PM1 Projekt 3, the first semester ZHAW Catan assignment. Source PDFs in `spec/`.

**Two implementations:**
- `implementation/catan-human/` — [boostvolt/zhaw-catan](https://github.com/boostvolt/zhaw-catan), a public first semester student team's implementation. Used as the human control.
- `implementation/catan-ai/` — a fresh Java implementation generated in a single agentic Claude Opus session from the consolidated spec. See `implementation/PROMPT.md` for the exact prompt used, preserved verbatim.

Both implementations target the same scope (Teilaufgabe 1 + 2 + 3 with the Robber variant) and share the same fixed library code (`ch.zhaw.hexboard`).

## Folder map

| Folder | Contents | Owner | Week |
|---|---|---|---|
| `spec/` | Original assignment PDFs (Anleitung + Kick-Off). Authoritative spec. | — | — |
| `tool-survey/` | Evaluation of GitHub's security stack (Dependabot, Code Security, Secret Protection, Copilot code review / Dependency Review) on a Node.js bench project. Selects tool(s) to apply to Catan. | kottjan01 | 2 |
| `implementation/` | `SPEC.md`, `PROMPT.md`, `catan-human/`, `catan-ai/`. | matamar | 2 |
| `results/` | Raw scan outputs per implementation. | matamar + kottjan01 | 3 |
| `reflection/` | Decision rationale, difficulties, tradeoffs, limitations, future work. | daotro01 | 4 |
| `demo/` | Live demo script and materials for presentation day. | daotro01 + galinpab | 5-6 |

## Relationship to Task 3 short report

The short report (`task-3-report/short-report-draft.md`) has a stub Section 4 that will be filled in once this case study produces scan results. The reflection documents here are the raw material for that section; the short report is the synthesis.
