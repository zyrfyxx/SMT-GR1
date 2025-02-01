import z3
from z3 import *

def create_z3_variables(variable_types):
 
    z3_vars = {}
    for name, var_type in variable_types.items():
        if var_type == 'float':
            z3_vars[name] = Real(name)
        else:  # var_type == 'int'
            z3_vars[name] = Int(name)
    return z3_vars

def add_constraints(solver, expression_dict, z3_vars):

    # print(z3_vars)
    for expr, expected_value in expression_dict.items():
        z3_expr = eval(expr, {}, z3_vars)
        if expected_value:  
            solver.add(z3_expr)
        else:  
            solver.add(Not(z3_expr))

import fractions
def extract_results(model, z3_vars):
 
    results = {}
    for name, var in z3_vars.items():
        # print(var.sort())
        # print(type(var.sort()))
        # print(type(var.sort().is_real()))
        if var.sort().is_real():
            # print(name)
            # print(str(var))
            # print(model[var])
            # print(model[var].ctx)
            value = model[var]
            # print(value)
            results[name] = float(fractions.Fraction(value.as_string()))
            # print(results[name])

        else:
            results[name] = model[var].as_long()
    return results

def solve_variables(expression_dict, variable_types):
  
    z3_vars = create_z3_variables(variable_types)
    solver = Solver()
    add_constraints(solver, expression_dict, z3_vars)

    if solver.check() == sat:
        model = solver.model()
        # print(model)
        return extract_results(model, z3_vars)
    else:
        return None

