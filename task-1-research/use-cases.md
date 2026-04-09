# Use Cases from Industry

Two real-world cases that we use in the draft and will carry into the short report. Both directly implicate AI-assisted development.

---

## 1. Clawdbot / Moltbot / OpenClaw (Nov 2025 – Feb 2026) — *primary*

Open-source autonomous AI agent framework published by Peter Steinberger in November 2025. In the last week of January 2026 it reached **149,000 GitHub stars**, was renamed twice in four days (Anthropic trademark complaint → "Moltbot" → "OpenClaw"), and during the rename window crypto scammers hijacked the GitHub organisation and X handle in the ~10-second gap. The cascade exposed **1.49 million database records**, enabled an **$8M crypto scam**, and — as *Axios* reported and Bitdefender confirmed — left hundreds of control interfaces accessible on the public internet, exposing chat logs, API keys, and remote command execution.

**Why it matters.** Compresses all four challenge clusters into a single week: insecure-by-default AI-generated agent code, a review bottleneck no process could absorb at 149k stars/week, a novel supply-chain dimension (an *agent* is code that executes code — downstream users inherit an active execution environment), and ecosystem stress at a scale that drew trademark conflict, account hijacks, and a crypto-scam pile-on within days. Every prevention tool that should have caught it existed; none operated at the speed the incident required.

**Numbers to verify before the short report.** 149,000 GitHub stars, 1.49M database records, $8M crypto scam, 10-second hijack window. Currently sourced from secondary reporting. We need to cross-check against the primary Unit 42 analysis.

**Sources.** Unit 42; Kaspersky; CyberNews; DEV Community timeline; Axios (news); Bitdefender.

---

## 2. curl bug bounty closure (2025) — *primary*

curl, maintained by Daniel Stenberg, ran a security bug bounty for years. Throughout 2025 it was overwhelmed by AI-generated "vulnerability" reports — well-written, plausible, almost entirely wrong. The valid-report rate dropped to **~5%**. At the start of 2026, Stenberg closed the program.

**Why it matters.** The LeadDev 12× asymmetry applied to security triage instead of code review. Reports used correct security vocabulary so they passed the surface check. curl tried stricter guidelines, templates, and published bad-submission examples; nothing worked. The case demonstrates the **absence** of solutions: no AI-aware triage tool, no reporter-reputation system, and no validation layer succeeded at a rate that preserved maintainer sanity.

**Sources.** The New Stack; LeadDev; All Things Open.

---

## What the two cases tell us together

| Case | Cluster exercised | What existing solutions failed to do |
|---|---|---|
| Clawdbot / OpenClaw | Security + review + supply chain + ecosystem | Operate at the speed AI projects evolve |
| curl bug bounty | Review + shallow plausibility | Filter AI slop from real reports |

Both point to the same gap: **review, triage, and verification capacity has not kept pace with the rate at which AI is producing code, contributions, and agents.** That gap is the target of our Task 2 case study.

---

## Cases we considered but cut from the draft

- **Ghostty (2025)** — open source terminal emulator that banned all AI-generated contributions in its contribution guidelines. Cut because it is essentially a one-line corollary to curl: same economics, smaller scale.
- **axios npm supply-chain compromise (March 31, 2026)** — malicious `axios@1.14.1` and `axios@0.30.4` packages published from a compromised maintainer account, delivering a cross-platform RAT via a pre-staged `plain-crypto-js@4.2.1` postinstall script. Microsoft Threat Intelligence attributed it to Sapphire Sleet (North Korean state actor). Cut because the root cause was a hijacked maintainer account, not AI-generated code, so the connection to our thesis required defensive framing that costs more space than the case is worth in a draft. Could come back in the Task 3 short report as the supply-chain illustration if there is room.
