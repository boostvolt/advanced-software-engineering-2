
# ASE – AI-Assisted Software Engineering (Team 08)

This repository contains the complete project developed for the **Advanced Software Engineering (ASE)** course. The project investigates one of the central challenges of large and complex software systems in practice, namely **AI-assisted Software Engineering (AI-assisted SWE)**.

The work combines theoretical research with a practical case study in order to examine how AI-based development tools affect software engineering workflows, developer decision-making, and system-level outcomes. The focus is not limited to potential productivity gains. Equal attention is given to the engineering concerns that arise when these tools are used in realistic settings, including correctness, trust, context limitations, governance, and the trade-offs between speed and validation.

The repository is organized explicitly around the official ASE project tasks. This task-oriented structure is intended to make the progression of the project transparent, from topic selection and literature review to case-study execution, reporting, class activity, presentation, and discussion material.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Folders in Detail](#folders-in-detail)
- [Methodological Summary](#methodological-summary)
- [Current Scope and Deliverables](#current-scope-and-deliverables)
- [Authors](#authors)
- [License](#license)

---

## Project Overview

The project addresses the broader ASE objective of studying real challenges in large-scale software systems through both analysis and application. In this repository, that challenge is approached through the lens of AI-assisted software engineering. The research component examines existing literature, industry evidence, and representative use cases. The practical component evaluates a selected AI-assisted solution through a concrete case-study workflow.

The repository therefore serves two purposes at once. First, it documents the conceptual basis of the project, including motivations, challenges, literature, and use cases. Second, it provides the project artifacts required for submission and presentation, including the case-study documentation, short report, classroom activity, presentation material, and discussion material.

---

## Project Structure

The repository follows a task-oriented organization aligned with the ASE evaluation framework. Its current directory layout is:

```
.
├── LICENSE
├── README.md
├── references
│   └── references.md
├── task-1-research
│   ├── challenges.md
│   ├── literature-review.md
│   ├── motivations.md
│   ├── topic-definition.md
│   └── use-cases.md
├── task-2-case-study
│   ├── case-study-design.md
│   ├── demo
│   │   └── demo-guide.md
│   ├── implementation
│   │   └── README.md
│   ├── overview.md
│   ├── reflection.md
│   ├── results
│   │   └── README.md
│   ├── selected-solution.md
│   └── solutions-analysis.md
├── task-3-report
│   ├── short-report.md
│   └── short-report.pdf
├── task-4-activity
│   ├── activity-description.md
│   └── materials
│       ├── facilitator-notes.md
│       └── participant-handout.md
├── task-5-presentation
│   ├── notes.md
│   ├── slides-outline.md
│   └── slides.pdf
├── task-6-discussion
│   ├── discussion-slide.md
│   └── discussion-slide.pdf
└── task-spec.md

12 directories, 27 files
---

## **Folders in Detail**

### **Task 1 – Research (`task-1-research/`)**

This section establishes the conceptual and literature-based foundation of the project. It defines the topic, explains its relevance, identifies the main technical and organizational challenges, and connects these challenges to evidence from both academic and industry sources.

- **`topic-definition.md`**
  defines AI-assisted software engineering in the context of large and complex systems and clarifies the scope of the project.

- **`motivations.md`**
  explains why the topic is relevant for modern software engineering, particularly in environments characterized by scale, interdependence, and high coordination cost.

- **`challenges.md`**
  discusses the main issues associated with AI-assisted SWE, including trust in generated output, limited system context, evaluation difficulty, security concerns, and governance requirements.

- **`literature-review.md`**
  synthesizes the main findings from the selected academic papers, research reports, and industry publications used throughout the project.

- **`use-cases.md`**
  presents real-world examples from industry and highlights both positive adoption cases and cautionary cases.

This task corresponds directly to the ASE requirement of selecting a topic, studying its motivations, identifying the main challenges, and reporting at least two use cases from practice.

---

### **Task 2 – Case Study (`task-2-case-study/`)**

This section constitutes the practical core of the repository. Its role is to investigate existing solutions for AI-assisted SWE, justify the selected solution, document how it is applied to the chosen case-study setting, and reflect on the resulting trade-offs and gaps.

- **`overview.md`**
  introduces the case study, its scope, and the evaluation perspective used in the project.

- **`case-study-design.md`**
  explains how the case study is structured and clarifies the intended workflow, evaluation logic, and demonstration strategy.

- **`solutions-analysis.md`**
  compares the main categories of candidate solutions considered during the investigation, such as general-purpose chat-based tools, repository-integrated assistants, and more agentic systems.

- **`selected-solution.md`**
  documents the selected solution and explains why it was preferred over the discarded alternatives.

- **`implementation/README.md`**
  describes the implementation environment and provides the basis for the practical application of the selected solution.

- **`results/README.md`**
  documents the observed outcomes of the implementation and evaluation process.

- **`demo/demo-guide.md`**
  provides the basis for a reproducible demonstration that can be shown during the class presentation.

- **`reflection.md`**
  contains the critical assessment of the case study, including rationale, encountered difficulties, observed trade-offs, limitations, and possible future directions.

This part of the repository is intended to address the central ASE requirement of moving from literature and general claims to a concrete engineering application. Its quality depends not only on structure, but also on the inclusion of real implementation experience and genuine reflection on what was observed during the case study.

---

### **Task 3 – Report (`task-3-report/`)**

This folder contains the short report required by the project specification. The markdown version is kept for traceability and easier editing, while the PDF version serves as the submission-ready artifact.

- **`short-report.md`**
  is the editable source version of the report.

- **`short-report.pdf`**
  is the final report artifact intended for submission.

The report summarizes the context and motivation of the topic, formulates the problem and key trade-offs, and presents the principal ideas, results, and limitations of the project in a compact format.

---

### **Task 4 – Activity (`task-4-activity/`)**

This section contains the class activity developed to communicate the topic in an interactive way. The activity is designed to make participants engage directly with one of the project’s main conclusions: that AI-assisted software engineering is not only about fast output, but also about judgment, validation, and engineering trust.

- **`activity-description.md`**
  explains the objective, structure, and rationale of the activity.

- **`materials/participant-handout.md`**
  contains the material distributed to the class during the activity.

- **`materials/facilitator-notes.md`**
  contains the guidance needed to moderate the activity and connect it back to the project findings.

---

### **Task 5 – Presentation (`task-5-presentation/`)**

This folder contains the material used to prepare and deliver the final presentation.

- **`slides-outline.md`**
  provides the slide-by-slide conceptual structure of the presentation.

- **`notes.md`**
  contains the presenter notes and delivery guidance.

- **`slides.pdf`**
  is the final slide deck artifact.

The presentation is intended for an academic audience with practical software-engineering experience and is structured around the main findings of Task 1, the main results of Task 2, the activity from Task 4, and the overall lessons learned from the project.

---

### **Task 6 – Discussion (`task-6-discussion/`)**

This section contains the material required for the critical discussion of another team’s short report.

- **`discussion-slide.md`**
  is the editable source version of the discussion content.

- **`discussion-slide.pdf`**
  is the final slide artifact used during the discussion session.

This task is designed to support a concise but constructive critical review that addresses novelty, generalizability, relation to one’s own lessons learned, and one intentionally controversial question from the ASE specification.

---

### **References (`references/`)**

This folder contains the shared reference base used across the project.

- **`references.md`**
  centralizes the bibliography and supports consistent IEEE-style citation across the research, report, presentation, and activity material.

---

### **Project Specification (`task-spec.md`)**

This file contains the project requirements and grading criteria that guided the organization of the repository and the preparation of its deliverables.

---

### **Methodological Summary**

The project follows a staged and traceable methodology.

It begins with a literature-driven investigation of AI-assisted software engineering as a challenge in large and complex systems. This first stage establishes the conceptual background, identifies the most relevant challenges, and situates the topic within both academic and industry practice.

The second stage moves from theory to application by comparing available solution categories and selecting one for a practical case study. The selected solution is then documented, applied, and evaluated in a structured way. The objective is not only to show what the tool can do, but also to examine where its usefulness depends on task boundaries, human oversight, and system context.

The third stage translates the project into communicable deliverables. These include the short report, the class activity, the final presentation, and the discussion slide. Together, these artifacts are intended to show both the results of the project and the reasoning process behind them.

This methodology is designed to ensure that the project does not remain at the level of generic claims. Instead, it combines research, implementation, reflection, and communication in a way that is consistent with the goals of the ASE course.

---

### **Current Scope and Deliverables**

The repository is designed to mirror the full ASE task structure, but the level of finality differs by artifact.

Tasks 1 and 3 are represented by completed research and reporting material. Task 4 is represented by a complete activity design and its supporting material. Tasks 5 and 6 include both editable source files and final PDF artifacts for presentation and discussion. Task 2 provides the structure and core documentation for the practical case study, but its final strength depends on the degree to which the implementation, results, and reflections are grounded in the team’s actual case-study experience rather than only in literature synthesis.

For this reason, the repository should be understood not only as a storage location for deliverables, but also as an auditable project record that connects requirements, reasoning, and outcomes.

---

### **Authors**

- **Dao Trong-Nghia** (daotro01)
- **Mata Marco** (matamar)
- **Galindo Lopez Pablo Emiliano** (galinpab)

### **License**

All Rights Reserved. 
